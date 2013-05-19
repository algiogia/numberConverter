package com.ivano.numbers.service;

public class NumberConverter {

	private final Dictionary dictionary;

	public NumberConverter(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public String convert(int number) {

		if (number > dictionary.getMaximumKnown()
				|| number < dictionary.getMinimumKnown()) {
			throw new IllegalArgumentException(
					"Sorry, this tool can only convert numbers from "
							+ dictionary.getMinimumKnown() + " to "
							+ dictionary.getMaximumKnown());
		}

		// check for special cases
		String special = dictionary.getNumberName(number);
		if (special != null) {
			return special;
		}

		StringBuffer stringNumber = new StringBuffer(String.valueOf(number));
		StringBuffer numberName = new StringBuffer();

		int multiplier = 1;
		while (stringNumber.length() > 0) {
			String triplet = extractTriplet(stringNumber);

			String multiplierName = dictionary.getClassName(multiplier);
			if (multiplierName != null)
				numberName.insert(0, multiplierName + " ");
			numberName.insert(0, convertTriplet(triplet));
			multiplier *= 1000;
		}

		return numberName.toString();
	}

	private String extractTriplet(StringBuffer stringNumber) {

		String triplet;
		int end = stringNumber.length();
		int start = end < 4 ? 0 : end - 3;

		triplet = stringNumber.substring(start, end);
		stringNumber.delete(start, end);
		return triplet;
	}

	private String convertTriplet(String triplet) {

		int tripletValue = Integer.valueOf(triplet);

		// Check if the dictionary can name the triplet...
		String result = dictionary.getNumberName(tripletValue);
		if (result != null) {
			return result;
		}

		// ...otherwise name each digit
		StringBuffer resultBuffer = new StringBuffer();
		int multiplier = (int) Math.pow(10, triplet.length() - 1);
		for (int digit : extractDigits(triplet)) {

			if (digit != 0) {
				resultBuffer.append(dictionary
						.getNumberName(digit * multiplier) + " ");
			}
			multiplier /= 10;
		}

		return resultBuffer.toString().trim();
	}

	private int[] extractDigits(String triplet) {

		int[] result = new int[triplet.length()];
		for (int i = 0, len = triplet.length(); i < len; i++) {
			result[i] = Integer.valueOf(String.valueOf(triplet.charAt(i)));
		}

		return result;
	}
}
