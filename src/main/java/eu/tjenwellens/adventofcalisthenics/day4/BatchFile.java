package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class BatchFile {
	private final List<String> lines;

	public Passports parse() {
		Passports.PassportsBuilder result = Passports.builder();
		for (List<String> lines : groupLinesDelimitedByBlankLine()) {
			result.passport(new MultilinePassport(lines).parsePassword());
		}
		return result.build();
	}

	private List<List<String>> groupLinesDelimitedByBlankLine() {
		List<List<String>> result = new LinkedList<>();
		List<String> linesForCurrentPassword = new LinkedList<>();
		for (String line : lines) {
			if (line.isBlank()) {
				result.add(linesForCurrentPassword);
				linesForCurrentPassword = new LinkedList<>();
				continue;
			}

			linesForCurrentPassword.add(line);
		}
		result.add(linesForCurrentPassword);
		return result;
	}
}
