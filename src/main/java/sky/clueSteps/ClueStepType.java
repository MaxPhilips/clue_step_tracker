package sky.clueSteps;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Predicate;

@AllArgsConstructor
@Getter
enum ClueStepType
{
	BEGINNER_CLUE(ClueStepConfig::trackBeginner),
	EASY_CLUE(ClueStepConfig::trackEasy),
	MEDIUM_CLUE(ClueStepConfig::trackMedium),
	HARD_CLUE(ClueStepConfig::trackHard),
	ELITE_CLUE(ClueStepConfig::trackElite),
	MASTER_CLUE(ClueStepConfig::trackMaster);

	private final Predicate<ClueStepConfig> enabled;
}
