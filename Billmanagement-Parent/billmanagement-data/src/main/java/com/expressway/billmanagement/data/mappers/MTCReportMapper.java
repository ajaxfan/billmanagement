package com.expressway.billmanagement.data.mappers;

import java.util.List;

import com.expressway.billmanagement.data.models.MTCReport;
import com.expressway.billmanagement.data.protocal.ConditionFiled;

import tk.mybatis.mapper.common.Mapper;

/**
 * MTC报表
 * 
 * @author Kalo
 */
public interface MTCReportMapper extends Mapper<MTCReport>{
    public List<MTCReport> findByCondition(ConditionFiled fields);
}
