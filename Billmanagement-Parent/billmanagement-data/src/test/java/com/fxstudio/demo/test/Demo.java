package com.fxstudio.demo.test;

import org.junit.Test;

import com.fxstudio.demo.AbstractClazz;
import com.fxstudio.demo.Clazz;

public class Demo {
    @Test
    public void test(){
        AbstractClazz clazz = new Clazz();
        clazz.print();
    }
}
