package com.curtain.ddd.common;

/**
 * @author Curtain
 * @date 2019/2/15 16:27
 */
public class AssertionConcern {

    public static void assertArgumentNotNull(Object obj,String message){
        if (obj==null){
            throw new IllegalArgumentException(message);
        }
    }

    public static void assertArgumentLength(String arg, int minimum, int maximum, String message) {
        int length = arg.trim().length();
        if (length < minimum || length > maximum) {
            throw new IllegalArgumentException(message);
        }
    }
}
