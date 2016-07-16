package org.billmanagement.data;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.expressway.billmanagement.data.mappers.SystemUserMapper;

public class DataModuleTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
        SystemUserMapper mapper = (SystemUserMapper) context.getBean("systemUserMapper");

        System.out.println(mapper.selectAll().size());

        context.close();
    }
}
