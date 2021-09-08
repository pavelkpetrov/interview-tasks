package com.interview.tasks.test;

import com.interview.tasks.FizzBuzz;
import com.interview.tasks.Sha1;
import org.junit.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 */
public class FizzBuzzTest {

    @Test
    public void testFizzBuzz100() throws Exception {
        final String fizzBuzz = FizzBuzz.toFizzBuzzStream(IntStream.range(1, 100)).collect(joining(","));
        assertThat(Sha1.sha1(fizzBuzz), equalTo("99b7d33c6313d2163df4f81aaad63cb15d255a86"));
    }

    @Test
    public void testFizzBuzz1000() throws Exception {
        final String fizzBuzz = FizzBuzz.toFizzBuzzStream(IntStream.range(1, 1000)).collect(joining(","));
        assertThat(Sha1.sha1(fizzBuzz), equalTo("894264635fb10dd1c172c64687cacefb917f55f4"));
    }

}
