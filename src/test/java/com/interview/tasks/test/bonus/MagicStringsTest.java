package com.interview.tasks.test.bonus;

import org.junit.Assert;
import org.junit.Test;

/**
 * Magic strings.
 *
 * This task is hard.
 *
 * Only change the code inside the magic function, and get this test to pass.
 *
 */
public class MagicStringsTest {

    @Test
    public void testName() throws Exception {
        magic();
        Assert.assertEquals("Hello world", "Hello ums");
    }

    private void magic() throws Exception {
        // Start code
        String password = "Hello world".intern();
        String fake = "Hello ums".intern();

        UnsafeHelper helper = new UnsafeHelper();
        helper.getUnsafe().copyMemory(
                fake, 0L, null, helper.toAddress(password), helper.sizeOf(fake));

        // End code
    }
}
