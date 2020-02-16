package ar.com.veterinaria.app.helper.service;

import java.util.regex.Pattern;

public abstract class BaseServiceHelper {
	private static final String NAME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
	private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

	protected static Pattern getNamePattern() {
		return NAME_PATTERN;
	}

}
