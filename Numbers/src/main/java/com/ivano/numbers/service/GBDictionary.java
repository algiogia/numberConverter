package com.ivano.numbers.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GBDictionary implements Dictionary {

	private static final int MAX_KNOWN_NUMBER = 999999999;

	private static final int MIN_KNOWN_NUMBER = 0;

	private static final Map<Integer, String> UNITS_BY_POSITION;
	static {
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(100, " hundred");
		m.put(1000, " thousand");
		m.put(1000000, " million");

		UNITS_BY_POSITION = Collections.unmodifiableMap(m);
	}

	private static final Map<Integer, String> TEENS;
	static {
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(0, "zero");
		m.put(1, "one");
		m.put(2, "two");
		m.put(3, "three");
		m.put(4, "four");
		m.put(5, "five");
		m.put(6, "six");
		m.put(7, "seven");
		m.put(8, "eight");
		m.put(9, "nine");
		m.put(10, "ten");
		m.put(11, "eleven");
		m.put(12, "twelve");
		m.put(13, "thirteen");
		m.put(14, "fourteen");
		m.put(15, "fifteen");
		m.put(16, "sixteen");
		m.put(17, "seventeen");
		m.put(18, "eighteen");
		m.put(19, "nineteen");

		TEENS = Collections.unmodifiableMap(m);
	}

	private static final Map<Integer, String> TENS;
	static {
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(20, "twenty");
		m.put(30, "thirty");
		m.put(40, "forty");
		m.put(50, "fifty");
		m.put(60, "sixty");
		m.put(70, "seventy");
		m.put(80, "eighty");
		m.put(90, "ninety");

		TENS = Collections.unmodifiableMap(m);
	}

	private static final Map<Integer, String> HUNDREDS;
	static {
		String suffix = " " + UNITS_BY_POSITION.get(100);
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(100, TEENS.get(1) + suffix);
		m.put(200, TEENS.get(2) + suffix);
		m.put(300, TEENS.get(3) + suffix);
		m.put(400, TEENS.get(4) + suffix);
		m.put(500, TEENS.get(5) + suffix);
		m.put(600, TEENS.get(6) + suffix);
		m.put(700, TEENS.get(7) + suffix);
		m.put(800, TEENS.get(8) + suffix);
		m.put(900, TEENS.get(9) + suffix);

		HUNDREDS = Collections.unmodifiableMap(m);
	}

	public static String getCode() {
		return "GB";
	}

	public static String getDescription() {
		return "British English";
	}

	@Override
	public int getMaximumKnown() {
		return MAX_KNOWN_NUMBER;
	}

	@Override
	public int getMinimumKnown() {
		return MIN_KNOWN_NUMBER;
	}

	@Override
	public String getNumberName(int number) {

		// Is it teen?
		String result = TEENS.get(number);

		// Or tens?
		if (result == null) {
			result = TENS.get(number);
		}

		// Or hundreds?
		if (result == null && number > 99) {
			result = HUNDREDS.get(number);
		}

		return result;

	}

	@Override
	public String getClassName(int multiplier) {
		return UNITS_BY_POSITION.get(multiplier);
	}
}
