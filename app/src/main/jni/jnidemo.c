//
// Created by 徐镇东 on 2018/11/22.
//

#include "com_test_demos_demos_jni_JNiTest.h"

JNIEXPORT jstring JNICALL Java_com_test_demos_demos_jni_JNiTest_getStringFromNDK
  (JNIEnv *env, jclass type){
     return (*env)->NewStringUTF(env,"徐镇东NDK的第一行代码");
  }
