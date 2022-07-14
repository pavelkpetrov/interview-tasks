package com.interview.tasks.test.bonus;

import org.junit.Assert;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;


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
        // solution just for a 32bit java
        class UnsafeHelper {
            private Unsafe unsafe = null;

            public Unsafe getUnsafe() throws Exception {
                if (unsafe == null) {
                    Field f = Unsafe.class.getDeclaredField("theUnsafe");
                    f.setAccessible(true);
                    unsafe = (Unsafe) f.get(null);
                }
                return unsafe;
            }

            public long toAddress(Object obj) throws Exception{
                Object[] array = new Object[] {obj};
                long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
                return normalize(getUnsafe().getInt(array, baseOffset));
            }

            public long normalize(int value) {
                if(value >= 0) return value;
                return (~0L >>> 32) & value;
            }

            public long sizeOf(Object o) throws Exception {
                Unsafe u = getUnsafe();
                HashSet<Field> fields = new HashSet<Field>();
                Class c = o.getClass();
                while (c != Object.class) {
                    for (Field f : c.getDeclaredFields()) {
                        if ((f.getModifiers() & Modifier.STATIC) == 0) {
                            fields.add(f);
                        }
                    }
                    c = c.getSuperclass();
                }

                // get offset
                long maxSize = 0;
                for (Field f : fields) {
                    long offset = u.objectFieldOffset(f);
                    if (offset > maxSize) {
                        maxSize = offset;
                    }
                }

                return ((maxSize/8) + 1) * 8;   // padding
            }

        }

        String password = "Hello world".intern();
        String fake = "Hello ums".intern();

        UnsafeHelper helper = new UnsafeHelper();
        helper.getUnsafe().copyMemory(
                fake, 0L, null, helper.toAddress(password), helper.sizeOf(fake));

        // End code
    }
}
