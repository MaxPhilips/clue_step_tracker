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

	@Inject
	ClueStepOverlay(ClueStepPlugin clueStepPlugin, ClueStepConfig config)
	{
		this.clueStepPlugin = clueStepPlugin;
		this.config = config;
		showOnInventory();
		showOnEquipment();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem)
	{
		int steps;
		ClueWithConfig clueWithConfig = ClueWithConfig.findItem(itemId);

		if (clueWithConfig != null)
		{
			if (!clueWithConfig.getType().getEnabled().test(config))
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

			ClueStepType type = clue.getType();
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
		textComponent.setColor(Color.WHITE);
		textComponent.render(graphics);
	}
}
