package com.bogdankobylinsky.java.lab2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrimeNumbersFinderTest {

	@Test
	public void testFindPrimesWithMaxOnes() {
		// 127 in (10 system) is 1111111 in (2 system)
		assertEquals(127,
				PrimeNumbersFinder.getFirstNumberWithMaximumOnesInBinary(160));

		// 1021 in (10 system) is 1111111101 in (2 system)
		assertEquals(1021,
				PrimeNumbersFinder.getFirstNumberWithMaximumOnesInBinary(1111));
	}

	@Test
	public void testPrimes() {
		assertArrayEquals(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
				37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157 },
				PrimeNumbersFinder.findPrimesUpTo(160));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFake() {
		PrimeNumbersFinder.findPrimesUpTo(0);
	}
}
