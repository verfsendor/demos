//
// Created by 徐镇东 on 2018/11/22.
//

#include "com_test_demos_demos_jni_NewJniTest.h"

JNIEXPORT jstring JNICALL Java_com_test_demos_demos_jni_NewJniTest_getNewTxt
  (JNIEnv *env, jclass type){
     return (*env)->NewStringUTF(env,"徐镇东的第二行NDK代码");
  }


