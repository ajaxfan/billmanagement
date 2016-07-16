package com.expressway.billmanagement.data;

import tk.mybatis.mapper.entity.Example;

/**
 * 数据查询条件
 * 
 * @author Ajaxfan
 */
public class Condition extends Example {
    /**
     * @param entityClass
     */
    public Condition(Class<?> entityClass) {
        super(entityClass);
    }
}
