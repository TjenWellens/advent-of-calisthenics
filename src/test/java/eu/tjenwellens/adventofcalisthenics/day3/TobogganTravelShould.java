package eu.tjenwellens.adventofcalisthenics.day3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		private final Slope slope = new Slope(new Coordinate.Right(0), new Coordinate.Down(1));

		@Test
		void count_0_trees_when_there_are_no_trees() {
			final TravelMap map = TravelMap.parse(List.of(
					"."
			));
			final Navigator navigator = new Navigator(map);
			assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(0));
		}

		@Test
		void count_1_trees_when_there_is_one_tree() {
			final TravelMap map = TravelMap.parse(List.of(
					".",
					"#"
			));
			final Navigator navigator = new Navigator(map);
			assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(1));
		}

		@Test
		void count_0_trees_when_there_are_trees_but_not_in_slope_path() {
			final TravelMap map = TravelMap.parse(List.of(
					"..",
					".#"
			));
			final Navigator navigator = new Navigator(map);
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
			assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(2));
		}
	}

	@Nested
	@DisplayName("given slope=down-right")
	class DownRightSlope {
		private final Slope slope = new Slope(new Coordinate.Right(1), new Coordinate.Down(1));

		@Test
		void count_1_tree_when_there_is_a_tree_further_down_the_slope() {
			final TravelMap map = TravelMap.parse(List.of(
					"..",
					".#"
			));
			final Navigator navigator = new Navigator(map);
			assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(1));
		}
	}

	@Test
	void have_an_infinite_map_to_the_right() {
		final Slope slope = new Slope(new Coordinate.Right(3), new Coordinate.Down(1));
		final TravelMap map = TravelMap.parse(List.of(
				"..",
				".#"
		));
		final Navigator navigator = new Navigator(map);
		assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(1));
	}

	@Disabled
	@Test
	void part1_input() throws IOException {
		final Path path = Paths.get("src", "test", "resources", "day-3-input.txt");
		final List<String> input = Files.readAllLines(path);
		final Slope slope = new Slope(new Coordinate.Right(3), new Coordinate.Down(1));
		final TravelMap map = TravelMap.parse(input);
		final Navigator navigator = new Navigator(map);
		assertThat(navigator.countTreesAlongSlope(slope)).isEqualTo(new EncounteredTrees(292));
	}

	@Disabled
	@Test
	void multiply_trees_for_multiple_slopes() {
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
		final Slopes slopes = new Slopes(List.of(
				new Slope(new Coordinate.Right(1), new Coordinate.Down(1)),
				new Slope(new Coordinate.Right(3), new Coordinate.Down(1)),
				new Slope(new Coordinate.Right(5), new Coordinate.Down(1)),
				new Slope(new Coordinate.Right(7), new Coordinate.Down(1)),
				new Slope(new Coordinate.Right(1), new Coordinate.Down(2))
		));
		assertThat(navigator.multiplyTreesAlongSlopes(slopes)).isEqualTo(new EncounteredTrees(336));
	}

	@Test
	void multiply_trees_for_2_slopes() {
		final TravelMap map = TravelMap.parse(List.of(
				"..",
				"##",
				"##"
		));
		final Navigator navigator = new Navigator(map);
		final Slopes slopes = new Slopes(List.of(
				new Slope(new Coordinate.Right(0), new Coordinate.Down(1)),
				new Slope(new Coordinate.Right(1), new Coordinate.Down(1))
		));
		assertThat(navigator.multiplyTreesAlongSlopes(slopes)).isEqualTo(new EncounteredTrees(2 * 2));
	}
}
