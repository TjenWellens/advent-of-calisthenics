package eu.tjenwellens.adventofcalisthenics.day3;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
public class Slopes implements Iterable<Slope> {
	private final List<Slope> slopes;

	@Override
	public Iterator<Slope> iterator() {
		return slopes.iterator();
	}
}
