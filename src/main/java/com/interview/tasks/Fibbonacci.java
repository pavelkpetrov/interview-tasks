package com.interview.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

/**
 * Tools to generate fibbonacci numbers.
 *
 */
public interface Fibbonacci {

    /**
     * Source summ of 20 Fibbonacci digits
     */
    static long SOURCE = 2026369768940L;

    /**
     * Class to hold current parameters for Fibbonacci generator
     */
    static class FibbonacciStreamHolder {
        public long prev = 1;
        public long curr = 0;
    }

    /**
     * Creates a stream of Fibonacci numbers.
     *
     * This should be an infinite stream starting at 1, 1, 2, 3, 5 and so on.
     *
     * Accessing numbers beyond {@link Long#MAX_VALUE} will result in random overflow variables being returned.
     *
     * @return a stream of fibonacci numbers
     */
     static LongStream stream() {
         final FibbonacciStreamHolder holder = new FibbonacciStreamHolder();
         return LongStream.generate(() -> {
             long prev = holder.prev;
             long curr = holder.curr;
             long result = prev + curr;
             if (prev == 1 && curr == 0) {
                 holder.prev = 0;
                 holder.curr = 1;
             } else {
                 holder.prev = curr;
                 holder.curr = result;
             }
             return result;
         });
     }

    /**
     * Try to detect nearest (less or equal) Fibbonacci digit
     * @param n source digit
     * @return nearest (less or equal) Fibbonacci digit
     */
    static long nearestFibbo(final long n)
    {
        long a = 0, b = 1;
        while (b < n) {
            b += a;
            a = b - a;
        }
        return  b - n > n - a? a : b;
    }

    /**
     * Function to init list of decomposed SOURCE digit
     */
    static void initFibboList(List<Long> fibboList){
        long f = SOURCE;
        while (f > 0) {
            final long nearest = nearestFibbo(f);
            fibboList.add(nearest);
            f -= nearest;
        }
    }

    static LongStream evenFibbonacciNumbers() {
        final List<Long> fiboList = new ArrayList<>();
        initFibboList(fiboList);
        return stream().filter(fiboList::contains);
    }
}