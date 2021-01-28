package eu.tjenwellens.adventofcalisthenics.day3;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

@AllArgsConstructor
public class Route implements Iterable<Coordinate> {
	private final List<Coordinate> coordinates;

	public Route add(Coordinate coordinate) {
		List<Coordinate> newCoordinates = new LinkedList<>(coordinates);
		newCoordinates.add(coordinate);
		return new Route(newCoordinates);
	}

	@Override
	public Iterator<Coordinate> iterator() {
		return coordinates.iterator();
	}

	@Override
	public void forEach(Consumer<? super Coordinate> action) {
		coordinates.forEach(action);
	}

	@Override
	public Spliterator<Coordinate> spliterator() {
		return coordinates.spliterator();
	}
}
