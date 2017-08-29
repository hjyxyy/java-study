package jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

import static common.ProjectContants._1MB;

/**
 * Usage: <b> </b>
 * VM args: -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @author lucifer
 *         Date 2016-10-18
 *         Device Aurora R5
 */
public class DirectMemoryOom {
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
