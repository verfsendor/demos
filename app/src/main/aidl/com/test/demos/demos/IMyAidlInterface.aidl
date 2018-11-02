// IMyAidlInterface.aidl
package com.test.demos.demos;
import com.test.demos.demos.Message;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
            void connect();
            void sendMessage(in Message msg);
            List<Message> getMessage();
}
