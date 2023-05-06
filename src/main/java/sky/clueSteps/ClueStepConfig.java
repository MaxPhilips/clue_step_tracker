package sky.clueSteps;

import lombok.Data;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup(ClueStepConfig.GROUP)
public interface ClueStepConfig extends Config
{
	String GROUP = "clueSteps";
	String KEY_BEGINNER = "clueBeginner";
	String KEY_EASY = "clueEasy";
	String KEY_MEDIUM = "clueMedium";
	String KEY_HARD = "clueHard";
	String KEY_ELITE = "clueElite";
	String KEY_MASTER = "clueMaster";

	String ID_EASY = "idEasy";
	String ID_MEDIUM = "idMedium";
	String ID_HARD = "idHard";
	String ID_ELITE = "idElite";

	@Data(staticConstructor = "of")
	class ClueRange {
		private final Integer min;
		private final Integer max;
	}

	ClueRange STEPS_BEGINNER = new ClueRange(1, 3);
	ClueRange STEPS_EASY = new ClueRange(2, 4);
	ClueRange STEPS_MEDIUM = new ClueRange(3, 5);
	ClueRange STEPS_HARD = new ClueRange(4, 6);
	ClueRange STEPS_ELITE = new ClueRange(5, 7);
	ClueRange STEPS_MASTER = new ClueRange(6, 8);

	@ConfigItem(
			keyName = "trackBeginner",
			name = "Track beginner",
			description = "Show steps completed on beginner clues.",
			position = 1
	)
	default boolean trackBeginner()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackEasy",
			name = "Track easy",
			description = "Show steps completed on easy clues.",
			position = 2
	)
	default boolean trackEasy()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackMedium",
			name = "Track medium",
			description = "Show steps completed on medium clues.",
			position = 3
	)
	default boolean trackMedium()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackHard",
			name = "Track hard",
			description = "Show steps completed on hard clues.",
			position = 4
	)
	default boolean trackHard()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackElite",
			name = "Track elite",
			description = "Show steps completed on elite clues.",
			position = 5
	)
	default boolean trackElite()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackMaster",
			name = "Track master",
			description = "Show steps completed on master clues.",
			position = 6
	)
	default boolean trackMaster()
	{
		return true;
	}

	@ConfigItem(
			keyName = "recolor",
			name = "Recolor step counter",
			description = "Recolors the step counter when the clue can be completed.",
			position = 7
	)
	default boolean recolor()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
			position = 8,
			keyName = "ColorPossibly",
			name = "Color Possibly",
			description = "Color when next step possibly results in a casket"
	)
	default Color getColorPossibly() {
		return Color.ORANGE;
	}

	@Alpha
	@ConfigItem(
			position = 9,
			keyName = "ColorProbably",
			name = "Color Probably",
			description = "Color when next step probably results in a casket"
	)
	default Color getColorProbably() {
		return Color.YELLOW;
	}

	@Alpha
	@ConfigItem(
			position = 10,
			keyName = "ColorGuaranteed",
			name = "Color Guaranteed",
			description = "Color when next step is a guaranteed casket"
	)
	default Color getColorGuaranteed() {
		return Color.GREEN;
	}
}
