package com.test.demos.demos.jni;

public class NewJniTest {

    static {
        System.loadLibrary("jnidemonew-jni");
    }

    @SuppressWarnings("JniMissingFunction")
    public static native String getNewTxt();

}
