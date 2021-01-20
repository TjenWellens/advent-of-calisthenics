package eu.tjenwellens.adventofcalisthenics.day3;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class EncounteredTrees {
	private final int trees;

	public EncounteredTrees(int trees) {
		this.trees = trees;
	}

	public EncounteredTrees add(EncounteredTrees other) {
		return new EncounteredTrees(this.trees + other.trees);
	}
}
