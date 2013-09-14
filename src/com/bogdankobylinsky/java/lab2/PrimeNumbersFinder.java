package com.bogdankobylinsky.java.lab2;

import java.util.ArrayList;

public class PrimeNumbersFinder {

	/**
	 * Getting first number that has maximum amount of ones in binary
	 * representation.
	 * 
	 * @param limit
	 *            the maximum number to check.
	 * @return the number that has maximum amount of ones.
	 * @throws IllegalArgumentException
	 *             if the limit is less than 2.
	 */
	public static int getFirstNumberWithMaximumOnesInBinary(int limit)
			throws IllegalArgumentException {
		int[] primes = findPrimesUpTo(limit);
		int primesAmount = primes.length;

		int primeWithMaximumOnes = primes[primes.length - 1];
		int ones = countOnesInNumber(primeWithMaximumOnes);
		for (int i = primesAmount - 1; i >= 0; i--)
			if (countOnesInNumber(primes[i]) > ones) {
				ones = countOnesInNumber(primes[i]);
				primeWithMaximumOnes = primes[i];
			}
		return primeWithMaximumOnes;
	}

	/**
	 * Counting ones in binary representation of number
	 * 
	 * @param number
	 * @return amount of ones in number
	 */
	public static int countOnesInNumber(int number) {
		String binaryNumber = Integer.toBinaryString(number);
		int ones = 0;
		int numberLength = binaryNumber.length();
		for (int i = 0; i < numberLength; i++)
			if (binaryNumber.charAt(i) == '1')
				ones++;
		return ones;
	}

	/**
	 * Getting the list of prime numbers (A prime number is a natural number
	 * greater than 1 that has no positive divisors other than 1 and itself. )
	 * 
	 * @param limit
	 *            the upper limit of prime numbers array.
	 * @return the ArrayList of prime numbers
	 * @throws IllegalArgumentException
	 *             if the limit is less than 2.
	 */
	public static int[] findPrimesUpTo(int limit)
			throws IllegalArgumentException {
		if (limit < 2)
			throw new IllegalArgumentException("The limit must be more than 2!");

		ArrayList<Integer> primes = new ArrayList<>();
		boolean prime = true;
		for (int number = 2; number <= limit; number++) {
			prime = true;
			for (int i = 2; i < number; i++)
				if (number % i == 0) {
					prime = false;
					break;
				}
			if (prime)
				primes.add(number);
		}
		int[] primesArray = new int[primes.size()];
		for (int i = 0; i < primes.size(); i++)
			primesArray[i] = primes.get(i);
		return primesArray;

	}
}
