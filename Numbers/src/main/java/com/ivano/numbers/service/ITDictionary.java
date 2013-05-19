package com.ivano.numbers.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ITDictionary implements Dictionary {

	private static final int MAX_KNOWN_NUMBER = 999999999;

	private static final int MIN_KNOWN_NUMBER = 0;

	private static final Map<Integer, String> UNITS_BY_POSITION;
	static {
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(100, "cento");
		m.put(1000, "mila");
		m.put(1000000, " milioni");

		UNITS_BY_POSITION = Collections.unmodifiableMap(m);
	}

	private static final Map<Integer, String> TEENS;
	static {
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(0, "zero");
		m.put(1, "uno");
		m.put(2, "due");
		m.put(3, "tre");
		m.put(4, "quattro");
		m.put(5, "cinque");
		m.put(6, "sei");
		m.put(7, "sette");
		m.put(8, "otto");
		m.put(9, "nove");
		m.put(10, "dieci");
		m.put(11, "undici");
		m.put(12, "dodici");
		m.put(13, "tredici");
		m.put(14, "quattordici");
		m.put(15, "quindici");
		m.put(16, "sedici");
		m.put(17, "diciassette");
		m.put(18, "diciotto");
		m.put(19, "diciannove");

		TEENS = Collections.unmodifiableMap(m);
	}

	private static final Map<Integer, String> TENS;
	static {
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(20, "venti");
		m.put(30, "trenta");
		m.put(40, "quaranta");
		m.put(50, "cinquanta");
		m.put(60, "sessanta");
		m.put(70, "settanta");
		m.put(80, "ottanta");
		m.put(90, "novanta");

		TENS = Collections.unmodifiableMap(m);
	}

	private static final Map<Integer, String> HUNDREDS;
	static {
		String suffix = " " + UNITS_BY_POSITION.get(100);
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(100, "cento");
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

	private static final Map<Integer, String> SPECIALS;
	static {
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(1000, "mille");
		m.put(21, "ventuno");
		m.put(31, "trentuno");
		m.put(41, "quarantuno");
		m.put(51, "cinquantuno");
		m.put(61, "sessantuno");
		m.put(71, "settantuno");
		m.put(81, "ottantuno");
		m.put(91, "novantuno");

		SPECIALS = Collections.unmodifiableMap(m);
	}

	public static String getCode() {
		return "IT";
	}

	public static String getDescription() {
		return "Italian";
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

		// Is it a special case?
		String result = SPECIALS.get(number);

		// ...or a teen?
		result = TEENS.get(number);

		// ...or tens?
		if (result == null) {
			result = TENS.get(number);
		}

		// ...or hundreds?
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
