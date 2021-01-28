package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.RequiredArgsConstructor;

import java.util.List;

public interface Rules {
	Validation isValid(Passport passport);
}
