package com.interview.tasks.test;

import com.interview.tasks.Sha1;
import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 */
public class Sha1Test {

    @Test
    public void testSha1() throws Exception {
        assertThat(Sha1.sha1("Hello world"), equalTo("7b502c3a1f48c8609ae212cdfb639dee39673f5e"));
    }

    @Test
    public void testSha1Stream() throws Exception {
        assertThat(Sha1.sha1(Stream.of("Hello", "World")), equalTo("4d984ec3e1ffabff374c44d9cbf224c13755a0e0"));

    }
}
