package org.billmanagement.data;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.expressway.billmanagement.data.mappers.BillThreeMapper;
import com.expressway.billmanagement.data.models.BillThree;

public class DataModuleTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
        BillThreeMapper mapper = (BillThreeMapper) context.getBean("billThreeMapper");

        System.out.println(((BillThree)(mapper.findByCondition(null).get(0))).getBillCount());

        context.close();
    }
}
