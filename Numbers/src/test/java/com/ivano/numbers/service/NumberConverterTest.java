package com.ivano.numbers.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberConverterTest {

	private NumberConverter nc = new NumberConverter(new GBDictionary());

	@Test
	public void aNumberIsConvertedToEnglish() {

		assertEquals("zero", nc.convert(0));

		assertEquals("eighteen", nc.convert(18));

		assertEquals("twenty three", nc.convert(23));

		assertEquals("one hundred twenty three", nc.convert(123));

		assertEquals("one thousand two hundred thirty four", nc.convert(1234));

		assertEquals("fifty one thousand two hundred thirty four",
				nc.convert(51234));

		assertEquals("fifty one thousand thirty four", nc.convert(51034));

		assertEquals(
				"one hundred twenty five thousand one hundred twenty three",
				nc.convert(125123));

		assertEquals(
				"seven million one hundred twenty five thousand one hundred twenty three",
				nc.convert(7125123));

		assertEquals(
				"nine hundred eighty seven million six hundred fifty four thousand three hundred twenty one",
				nc.convert(987654321));

	}

	@Test
	public void anExceptionOccursIfNumberExceedsMaximum() {

	}

	@Test
	public void anExceptionOccursIfInvalidNumberIsProvided() {

	}
}
