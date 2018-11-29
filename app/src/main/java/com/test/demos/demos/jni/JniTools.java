package com.test.demos.demos.jni;
public class JniTools {

        static {
                System.loadLibrary("jnidemo3");
        }

        //加法
        public static native int  addNumber(int a,int b);

        //减法
        public static native int subNumber(int a,int b);

        //乘法
        public static native int mulNumber(int a,int b);

        //除法
        public static native int divNumber(int a,int b);


}

