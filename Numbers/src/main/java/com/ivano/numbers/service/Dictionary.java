package com.ivano.numbers.service;

public interface Dictionary {

	/**
	 * Gets name of given number, if known.
	 * 
	 * @param number
	 *            number to name
	 * 
	 * @return name of the number if known, <code>null</code> otherwise
	 */
	public String getNumberName(int number);

	/**
	 * Gets name of numeric class.
	 * 
	 * @param multiplier
	 * 
	 * @return name of class if known, <code>null</code> otherwise
	 */
	public String getClassName(int multiplier);

	/**
	 * Gets dictionary's greatest known number.
	 * 
	 * @return dictionary upper limit
	 */
	public int getMaximumKnown();

	/**
	 * Gets dictionary's littlest known number.
	 * 
	 * @return dictionary lower limit
	 */
	public int getMinimumKnown();

}
