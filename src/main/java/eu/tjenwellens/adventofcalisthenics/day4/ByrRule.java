package eu.tjenwellens.adventofcalisthenics.day4;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ByrRule {
	public Validation isValid(Field field) {
		return field.valueBetween(1920, 2002);
	}
}
