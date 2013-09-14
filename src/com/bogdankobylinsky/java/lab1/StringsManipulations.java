package com.bogdankobylinsky.java.lab1;

import java.util.ArrayList;

/**
 * Working with Strings.
 * 
 * @author Bogdan
 * 
 */
public class StringsManipulations {

	/**
	 * Task #1
	 * 
	 * @param sentences
	 * @return all sentences from list that are bigger than average length.
	 * @throws NullPointerException
	 *             if passed array is not initialized
	 * @throws IllegalArgumentException
	 *             if array is empty
	 */
	public static String[] allocateBiggerSentences(String[] sentences)
			throws NullPointerException, IllegalArgumentException {
		float avgLength = getAverageLength(sentences);
		ArrayList<String> newSentences = new ArrayList<>();
		for (String sentence : sentences)
			if (sentence.length() > avgLength)
				newSentences.add(sentence);
		return newSentences.toArray(new String[0]);
	}

	/**
	 * Task #1
	 * 
	 * @param sentences
	 * @return all sentences from list that are smaller than average length.
	 * @throws NullPointerException
	 *             if passed array is not initialized
	 * @throws IllegalArgumentException
	 *             if array is empty
	 */
	public static String[] allocateSmallerSentences(String[] sentences)
			throws NullPointerException, IllegalArgumentException {
		float avgLength = getAverageLength(sentences);
		ArrayList<String> newSentences = new ArrayList<>();
		for (String sentence : sentences)
			if (sentence.length() < avgLength)
				newSentences.add(sentence);
		return newSentences.toArray(new String[0]);
	}

	/**
	 * Counting average length of all sentences.
	 * 
	 * @param sentences1
	 * @return average length.
	 * @throws NullPointerException
	 *             if passed array is not initialized
	 * @throws IllegalArgumentException
	 *             if array is empty
	 */
	public static float getAverageLength(String[] sentences)
			throws NullPointerException, IllegalArgumentException {
		if (sentences == null)
			throw new NullPointerException("Array must be initialized!");
		if (sentences.length == 0)
			throw new IllegalArgumentException("Array must be no empty!");
		float avgLength = 0;
		for (String sentence : sentences)
			avgLength += sentence.length();
		avgLength /= (float) sentences.length;
		return avgLength;
	}
}
