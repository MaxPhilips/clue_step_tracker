package sky.clueSteps;

import lombok.Data;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

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
	class Pair {
		private final Integer min;
		private final Integer max;
	}

	Pair STEPS_BEGINNER = new Pair(1, 3);
	Pair STEPS_EASY = new Pair(2, 4);
	Pair STEPS_MEDIUM = new Pair(3, 5);
	Pair STEPS_HARD = new Pair(4, 6);
	Pair STEPS_ELITE = new Pair(5, 7);
	Pair STEPS_MASTER = new Pair(6, 8);

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
}
