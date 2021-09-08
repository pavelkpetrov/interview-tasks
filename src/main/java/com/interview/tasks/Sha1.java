package com.interview.tasks;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Sha1 hash helper.
 */
public interface Sha1 {

    Charset UTF8 = Charset.forName("UTF-8");

    /**
     * Returns the sha1 of the input string.
     *
     * @param source string to get SHA-1 sum for
     * @return SHA-1 string of source
     * @throws NoSuchAlgorithmException
     */
    public static String sha1(String source) throws NoSuchAlgorithmException {
        //wrong hashing substitute with valid implementation of sha1 hashing
//        return ByteHelper.bytesToHex(source.substring(0, Math.min(16, source.length())).getBytes(UTF8));
        return ByteHelper.bytesToHex(DigestUtils.sha1(source.getBytes(UTF8)));
    }

    /**
     * Sha1 sum of a stream of strings.
     *
     * @param source stream of strings to get sha1 for
     * @return sha1 of the toString for the stream, using "," as delimiter.
     * @throws NoSuchAlgorithmException
     */
    static String sha1(Stream<String> source) throws NoSuchAlgorithmException {
        return sha1(source.collect(joining(",")));
    }
}
