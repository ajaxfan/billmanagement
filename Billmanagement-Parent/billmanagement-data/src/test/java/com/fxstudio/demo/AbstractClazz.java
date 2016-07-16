package com.fxstudio.demo;

import java.lang.annotation.Annotation;

import com.fxstudio.demo.annotations.ClazzInfo;

public abstract class AbstractClazz {
    public void print() {
        Class obj = this.getClass();

        // Process @TesterInfo
        if (obj.isAnnotationPresent(ClazzInfo.class)) {
            Annotation annotation = obj.getAnnotation(ClazzInfo.class);
            ClazzInfo clazzinfo = (ClazzInfo) annotation;

            for (String name : clazzinfo.names()) {
                System.out.println(name);
            }
        }
    }
}
