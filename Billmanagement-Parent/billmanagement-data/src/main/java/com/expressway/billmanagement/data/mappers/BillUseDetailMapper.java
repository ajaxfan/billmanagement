package com.expressway.billmanagement.data.mappers;

import java.util.List;

import com.expressway.billmanagement.data.models.BillUseDetail;
import com.expressway.billmanagement.data.protocal.ConditionFiled;

import tk.mybatis.mapper.common.base.BaseSelectMapper;

/**
 * 票据使用明细
 * 
 * @author Kalo
 */
public interface BillUseDetailMapper extends BaseSelectMapper<BillUseDetail>{
    public List<BillUseDetail> findByCondition(ConditionFiled fields);
}
