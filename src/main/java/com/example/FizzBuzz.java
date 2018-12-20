package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implements the output of the FizzBuzz problem with Java 8 Streams support
 * 
 * "Write a program that prints the numbers from 1 to 100. For multiples of
 * three print “Fizz” instead of the number and For the multiples of five print
 * “Buzz”. For numbers which are multiples of both three and five print
 * “FizzBuzz”."
 *
 */
public class FizzBuzz {

	public static final int LIMIT = 100;

	public static List<String> getOutput() {

		@SuppressWarnings("unchecked")
		List<String> output = (List<String>) ((List<?>) IntStream
				.rangeClosed(1, LIMIT).mapToObj(i -> {
					if (i % 3 == 0 && i % 5 != 0) {
						return "Fizz";
					} else if (i % 5 == 0 && i % 3 != 0) {
						return "Buzz";
					} else if (i % 5 == 0 && i % 3 == 0) {
						return "FizzBuzz";
					} else {
						return String.valueOf(i);
					}
				}).collect(Collectors.toCollection(ArrayList::new)));

		return output;
	}
}
