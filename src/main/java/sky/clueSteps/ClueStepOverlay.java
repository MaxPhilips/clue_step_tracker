package sky.clueSteps;

import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.components.TextComponent;

import javax.inject.Inject;
import java.awt.*;

class ClueStepOverlay extends WidgetItemOverlay
{
	private final ClueStepPlugin clueStepPlugin;
	private final ClueStepConfig config;

	private final Color NORMAL = Color.WHITE;

	@Inject
	ClueStepOverlay(ClueStepPlugin clueStepPlugin, ClueStepConfig config)
	{
		this.clueStepPlugin = clueStepPlugin;
		this.config = config;
		showOnInventory();
		showOnEquipment();
	}

	public ClueStepConfig.ClueRange GetStepRange(ClueStepType type)
	{
		switch (type)
		{
			case BEGINNER_CLUE:
				return ClueStepConfig.STEPS_BEGINNER;
			case EASY_CLUE:
				return ClueStepConfig.STEPS_EASY;
			case MEDIUM_CLUE:
				return ClueStepConfig.STEPS_MEDIUM;
			case HARD_CLUE:
				return ClueStepConfig.STEPS_HARD;
			case ELITE_CLUE:
				return ClueStepConfig.STEPS_ELITE;
			case MASTER_CLUE:
				return ClueStepConfig.STEPS_MASTER;
			default:
				return null;
		}
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem)
	{
		int steps;
		ClueWithConfig clueWithConfig = ClueWithConfig.findItem(itemId);
		ClueStepType type;

		if (clueWithConfig != null)
		{
			type = clueWithConfig.getType();
			if (!type.getEnabled().test(config))
			{
				return;
			}

			steps = clueStepPlugin.getClueSteps(clueWithConfig.getConfigKey());
		}
		else
		{
			ClueWithStep clue = ClueWithStep.findItem(itemId);
			if (clue == null)
			{
				return;
			}

			type = clue.getType();
			if (!type.getEnabled().test(config))
			{
				return;
			}

			steps = clue.getCharges();
		}

		graphics.setFont(FontManager.getRunescapeSmallFont());

		final Rectangle bounds = widgetItem.getCanvasBounds();
		final TextComponent textComponent = new TextComponent();
		textComponent.setPosition(new Point(bounds.x - 1, bounds.y + 15));
		textComponent.setText(steps < 0 ? "?" : String.valueOf(steps));
		textComponent.setColor(GetColor(steps, type));
		textComponent.render(graphics);
	}

	private Color GetColor(int steps, ClueStepType type)
	{
		if (!config.recolor())
		{
			return NORMAL;
		}

		int maxSteps = GetStepRange(type).getMax();
		switch (maxSteps - steps)
		{
			case 1:
				return config.getColorGuaranteed();
			case 2:
				return config.getColorProbably();
			case 3:
				return config.getColorPossibly();
			default:
				return NORMAL;
		}
	}
}
