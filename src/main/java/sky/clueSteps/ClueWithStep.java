package sky.clueSteps;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.annotation.Nullable;
import java.util.Map;

@AllArgsConstructor
@Getter
enum ClueWithStep
{
	;
	private final ClueStepType type;
	private final int id;
	private final int charges;

	private static final Map<Integer, ClueWithStep> ID_MAP;

	static
	{
		ImmutableMap.Builder<Integer, ClueWithStep> builder = new ImmutableMap.Builder<>();

		for (ClueWithStep clueStep : values())
		{
			builder.put(clueStep.getId(), clueStep);
		}

		ID_MAP = builder.build();
	}

	@Nullable
	static ClueWithStep findItem(int itemId)
	{
		return ID_MAP.get(itemId);
	}
}
