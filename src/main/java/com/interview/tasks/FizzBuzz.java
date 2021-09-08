package com.interview.tasks;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * FizzBuzz generator.
 *
 */
public interface FizzBuzz {

    /**
     * declare Fizz string constant
     */
    public final static String FIZZ = "Fizz";
    /**
     * declare Buzz string constant
     */
    public final static String BUZZ = "Buzz";
    /**
     * declare FizzBuzz string constant
     */
    public final static String FIZZ_BUZZ = "FizzBuzz";

    /**
     * Given an intStream, return a stream of strings following the FizzBuzz rules.
     * <p>
     * Any number divisible by 3 should be replaced by Fizz.
     * Any number divisible by 5 should be replaced by Buzz.
     * Any number divisible by 15 should be replaced by FizzBuzz.
     * All other numbers as is.
     *
     * @param intStream source stream
     * @return FizzBuzzStream
     */
    static Stream<String> toFizzBuzzStream(IntStream intStream) {
        return intStream.mapToObj(val -> {
            if (val % 15 == 0) {
                return FIZZ_BUZZ;
            } else if (val % 3 == 0) {
                return FIZZ;
            } else if (val % 5 == 0) {
                return BUZZ;
            }
            return String.valueOf(val);
        });
    }

}
