package com.expressway.billmanagement.data.mappers;

import java.util.List;

import com.expressway.billmanagement.data.models.ETCReport;
import com.expressway.billmanagement.data.protocal.ConditionFiled;

import tk.mybatis.mapper.common.base.BaseSelectMapper;

/**
 * ETC报表
 * 
 * @author Kalo
 */
public interface ETCReportMapper extends BaseSelectMapper<ETCReport>{
    public List<ETCReport> findByCondition(ConditionFiled fields);
}
