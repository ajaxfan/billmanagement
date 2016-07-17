package com.expressway.billmanagement.data.mappers;

import java.util.List;

import com.expressway.billmanagement.data.models.BillThree;
import com.expressway.billmanagement.data.protocal.ConditionFiled;

import tk.mybatis.mapper.common.base.BaseSelectMapper;

/**
 * 三联单
 * 
 * @author Kalo
 */
public interface BillThreeMapper extends BaseSelectMapper<BillThree> {
    public List<BillThree> findByCondition(ConditionFiled fields);
}
