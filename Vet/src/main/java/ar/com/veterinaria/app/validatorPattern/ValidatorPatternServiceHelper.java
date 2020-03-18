package ar.com.veterinaria.app.validatorPattern;

import java.util.regex.Pattern;

public class ValidatorPatternServiceHelper {
	private static final String NAME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
	private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

	private static final String NUMBER_REGEX = "^[0-9]";
	private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

	private static final String NUMBER_LETTER_REGEX = "^[0-9]^[a-zA-Z]*$";
	private static final Pattern NUMBER_LETTER_PATTERN = Pattern.compile(NUMBER_LETTER_REGEX);

	public static Pattern getNamePattern() {
		return NAME_PATTERN;
	}

	public static Pattern getNumberPattern() {
		return NUMBER_PATTERN;
	}

	public static Pattern getNumberLetterPattern() {
		return NUMBER_LETTER_PATTERN;
	}

}
