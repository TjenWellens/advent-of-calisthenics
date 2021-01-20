package eu.tjenwellens.adventofcalisthenics.day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TobogganTravelShould {
	@Test
	void count_trees_for_slope_right_3_down_1() {
		final TravelMap map = TravelMap.parse(List.of(
				"..##.......",
				"#...#...#..",
				".#....#..#.",
				"..#.#...#.#",
				".#...##..#.",
				"..#.##.....",
				".#.#.#....#",
				".#........#",
				"#.##...#...",
				"#...##....#",
				".#..#...#.#"
		));
		final Navigator navigator = new Navigator(map);
		final Slope slope = new Slope(new Right(3), new Down(1));
		assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(7));
	}

	@Test
	void count_0_trees_when_there_are_no_trees() {
		final TravelMap map = TravelMap.parse(List.of(
				"."
		));
		final Navigator navigator = new Navigator(map);
		final Slope slope = new Slope(new Right(3), new Down(1));
		assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(0));
	}
}
