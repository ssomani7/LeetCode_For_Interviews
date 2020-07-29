package trick_questions;

import java.util.Arrays;

/*
 * "Sieve of Eratosthenes" is an ancient algorithm for finding all prime numbers up to any given limit.
 * 
 * Time Complexity = O(n log log n)
 * Space Complexity = O(n)
 */

/*
 * Count the number of prime numbers less than a non-negative number, n.
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */

public class CountPrimes {

	public static int countPrimes(int n) {
		int primeCount = 0;
		boolean[] primeNums = new boolean[n];
		Arrays.fill(primeNums, true);
		
		//Skip index 0 and 1, as they cannot be prime and composite
		for(int index = 2; index * index < n; index++) {
			if(primeNums[index] == true) {
				//mark all the numbers false where index is a part of their factor
				for(int j = 2; j * index < n; j++) {
					primeNums[j * index] = false;
				}
			}
		}
		
		for(int i = 2; i < n; i++)
			if(primeNums[i] == true)
				primeCount++;
		
		return primeCount;
	}
	
	public static void main(String[] args) {
		int n = 10;
		
		System.out.println("Number of primes under " + n + " = " + countPrimes(n));
	}

}
