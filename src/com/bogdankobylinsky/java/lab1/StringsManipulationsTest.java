package com.bogdankobylinsky.java.lab1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringsManipulationsTest {

	private String[] sentences1, sentences2;

	@Before
	public void setUpSentences() {
		//
		// First list of sentences.
		//
		sentences1 = new String[] { "This is a first sentence.", // 25 symbols
				"I want BMW Gran Coupe.", // 22
				"Today is the next day before yesterday.", // 39
				"I am awesome.", // 13
				"Java is the best programming language ever." }; // 43

		//
		// Second list of sentences.
		//
		sentences2 = new String[] { "First.", // 6
				"Second.", // 7
				"Little bit longer.", // 18
				"Longer than previous.", // 21
				"Average len_." }; // 13
		// Overall average amount of symbols is 13
	}

	@Test
	public void testBiggerSentences() {

		String[] biggerSentences1 = new String[] {
				"Today is the next day before yesterday.",
				"Java is the best programming language ever." };

		String[] biggerSentences2 = new String[] { "Little bit longer.",
				"Longer than previous." };

		assertArrayEquals(biggerSentences1,
				StringsManipulations.allocateBiggerSentences(sentences1));

		assertArrayEquals(biggerSentences2,
				StringsManipulations.allocateBiggerSentences(sentences2));
	}

	@Test
	public void testSmallerSentences() {
		String[] smallerSentences1 = new String[] {
				"This is a first sentence.", "I want BMW Gran Coupe.",
				"I am awesome." };
		String[] smallerSentences2 = new String[] { "First.", "Second." };

		assertArrayEquals(smallerSentences1,
				StringsManipulations.allocateSmallerSentences(sentences1));

		assertArrayEquals(smallerSentences2,
				StringsManipulations.allocateSmallerSentences(sentences2));
	}

	@Test
	public void testEqualArrayElements() {
		// The task is to allocate bigger or smaller sentences than average
		// length, but not equal. So sentences that equal average length are
		// ignored.

		String[] equalSentences = new String[] { "The sentence.",
				"_Programming.", "ASUS UL-30-A." }; // All lengths are 13.

		String[] emptyArray = new String[0];
		assertArrayEquals(emptyArray,
				StringsManipulations.allocateBiggerSentences(equalSentences));
		assertArrayEquals(emptyArray,
				StringsManipulations.allocateSmallerSentences(equalSentences));
	}

	@Test
	public void testGetAverageLength() {
		String[] testArray1 = new String[] { "", "_2", "___4" };
		assertEquals(2.0, StringsManipulations.getAverageLength(testArray1),
				1e-10);
		testArray1 = new String[] { "55555", "1", "666666" };
		assertEquals(4.0, StringsManipulations.getAverageLength(testArray1),
				1e-10);
	}

	@Test(expected = NullPointerException.class)
	public void testForNull() {
		StringsManipulations.allocateSmallerSentences(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testForEmpty() {
		StringsManipulations.allocateSmallerSentences(new String[] {});
	}
}
