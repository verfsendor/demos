package com.test.demos.demos.jni;

public class JNiTest {
    static {
        System.loadLibrary("jnidemo-jni");
    }
    @SuppressWarnings("JniMissingFunction")
    public static native String getStringFromNDK();
}
