// Given an array of integers representing a sequence of consecutive numbers with exactly one number missing, write a method to find the missing number.

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayMissingNumber{
	// How would you implement a method to find the missing number in a given sequence of integers using the additive approach? The method should iterate through the sequence to calculate the expected sum and compare it with the actual sum of the given array elements.
	public static int arrayMissingNumberAddition(int[] givenArr) {
        int givenSum = 0, expectedSum = 0;
        int n = givenArr.length + 1;

        for (int i = 1; i <= n; i++) {
            expectedSum += i;
        }
        for (int i : givenArr) {
            givenSum += i;
        }

        int missingNumber = expectedSum - givenSum;
		return missingNumber;
    }
	
	// Can you devise a method that applies the arithmetic series sum formula to determine the missing number in a sequence of consecutive numbers? The method should calculate the expected sum based on the length of the array and subtract the actual sum of the array elements to find the missing number.
	public static int arrayMissingNumberFormula(int[] givenArr) {
		int n = givenArr.length+1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;		

        for (int number : givenArr) {
            actualSum += number;
        }

        return expectedSum - actualSum;
    }
	
	// What would be your approach to writing a method that uses the XOR operation to identify the missing number in a sequence of integers? The method should XOR all the numbers in the given array and the complete sequence, then XOR the results to reveal the missing number.
	public static int arrayMissingNumberXor(int[] givenArr) {
        int xorArray = 0;
        int xorFull = 0;
		int n = givenArr.length+1;

        for (int number : givenArr) {
            xorArray ^= number;
        }

        for (int i = 1; i <= n; i++) {
            xorFull ^= i;
        }

        return xorArray ^ xorFull;
    }
	
	// Could you outline a method that utilizes Java Streams to calculate the missing number in a sequence of integers? The method should use the IntStream range and Arrays.stream methods to compute the expected and actual sums, respectively, and then find the missing number by their difference.
	public static int arrayMissingNumberStream(int[] givenArr) {
        int expectedSum = IntStream.rangeClosed(1, givenArr.length+1).sum();
        int actualSum = Arrays.stream(givenArr).sum();
        int missingNumber = expectedSum - actualSum;

        return missingNumber;
    }

	public static void main(String[] args){
		int[] arr = {1, 2, 4, 5, 6};
		System.out.println("Stream: " + arrayMissingNumberStream(arr));
		System.out.println("Xor: " + arrayMissingNumberXor(arr));
		System.out.println("Formula: " + arrayMissingNumberFormula(arr));
		System.out.println("Addition: " + arrayMissingNumberAddition(arr));
	}
}