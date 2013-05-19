package com.ivano.numbers.service;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NumberConverterTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void aNumberIsConvertedToEnglish() {

		NumberConverter nc = new NumberConverter(new GBDictionary());

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
	public void aNumberIsConvertedToItalian() {

		NumberConverter nc = new NumberConverter(new ITDictionary());

		assertEquals("zero", nc.convert(0));

		assertEquals("ventuno", nc.convert(21));

		assertEquals("ventunomila cinquecento tre", nc.convert(21503));

	}

	@Test
	public void anExceptionOccursIfNumberExceedsMaximum() {

		NumberConverter nc = new NumberConverter(new GBDictionary());

		exception.expect(IllegalArgumentException.class);
		nc.convert(1999999999);
	}

	@Test
	public void anExceptionOccursIfNumberIsExceedsMinimum() {

		NumberConverter nc = new NumberConverter(new GBDictionary());

		exception.expect(IllegalArgumentException.class);
		nc.convert(-1);
	}
}
