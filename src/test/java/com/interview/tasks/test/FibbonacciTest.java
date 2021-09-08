package com.interview.tasks.test;

import com.interview.tasks.Fibbonacci;
import com.interview.tasks.Sha1;
import org.junit.Test;

import java.util.stream.LongStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 */
public class FibbonacciTest {

    public void method1(){
        method2();
    }

    public void method2() throws RuntimeException{
        throw new RuntimeException("test");
    }

    @Test
    public void testFirstNumbers() throws Exception {
        final LongStream first10 = Fibbonacci.stream().limit(10);
        final String first10sha1 = Sha1.sha1(first10.mapToObj(String::valueOf));
        assertThat(first10sha1, equalTo("0e9ad414bb65d9b8f8dae4657db4cf0994485f56"));
    }

    @Test
    public void testEvenSum() throws Exception {
        assertThat(Fibbonacci.evenFibbonacciNumbers().limit(20).sum(), equalTo(2026369768940L));
    }
}
