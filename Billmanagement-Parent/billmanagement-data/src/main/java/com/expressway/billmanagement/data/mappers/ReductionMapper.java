package com.expressway.billmanagement.data.mappers;

import java.util.List;

import com.expressway.billmanagement.data.models.Reduction;
import com.expressway.billmanagement.data.protocal.ConditionFiled;

import tk.mybatis.mapper.common.base.BaseSelectMapper;

/**
 * 免费车
 * 
 * @author Kalo
 */
public interface ReductionMapper extends BaseSelectMapper<Reduction> {
    public List<Reduction> findByCondition(ConditionFiled fields);
}
