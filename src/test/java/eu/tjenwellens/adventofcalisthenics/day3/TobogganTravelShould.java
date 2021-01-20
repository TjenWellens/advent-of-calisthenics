package eu.tjenwellens.adventofcalisthenics.day3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TobogganTravelShould {
	@Disabled
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
		final Slope slope = new Slope(new Coordinate.Right(3), new Coordinate.Down(1));
		assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(7));
	}

	@Nested
	@DisplayName("given slope=straight-down")
	class StraightDownSlope {
		@Test
		void count_0_trees_when_there_are_no_trees() {
			final TravelMap map = TravelMap.parse(List.of(
					"."
			));
			final Navigator navigator = new Navigator(map);
			final Slope slope = new Slope(new Coordinate.Right(0), new Coordinate.Down(1));
			assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(0));
		}

		@Test
		void count_1_trees_when_there_is_one_tree() {
			final TravelMap map = TravelMap.parse(List.of(
					".",
					"#"
			));
			final Navigator navigator = new Navigator(map);
			final Slope slope = new Slope(new Coordinate.Right(0), new Coordinate.Down(1));
			assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(1));
		}

		@Test
		void count_0_trees_when_there_are_trees_but_not_in_slope_path() {
			final TravelMap map = TravelMap.parse(List.of(
					"..",
					".#"
			));
			final Navigator navigator = new Navigator(map);
			final Slope slope = new Slope(new Coordinate.Right(0), new Coordinate.Down(1));
			assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(0));
		}

		@Test
		void count_1_trees_when_there_is_a_tree_further_down_the_slope() {
			final TravelMap map = TravelMap.parse(List.of(
					".",
					".",
					"#"
			));
			final Navigator navigator = new Navigator(map);
			final Slope slope = new Slope(new Coordinate.Right(0), new Coordinate.Down(1));
			assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(1));
		}

		@Test
		void count_multiple_trees_along_the_slope() {
			final TravelMap map = TravelMap.parse(List.of(
					".",
					"#",
					"#"
			));
			final Navigator navigator = new Navigator(map);
			final Slope slope = new Slope(new Coordinate.Right(0), new Coordinate.Down(1));
			assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(2));
		}
	}
}
