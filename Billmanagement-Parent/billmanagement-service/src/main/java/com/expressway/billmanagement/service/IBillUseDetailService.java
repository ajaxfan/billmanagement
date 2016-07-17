package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.BillUseDetail;
import com.expressway.billmanagement.data.protocal.ConditionFiled;

/**
 * 票据使用明细服务
 * 
 * @author Ajaxfan
 */
public interface IBillUseDetailService {
    public List<BillUseDetail> getData(ConditionFiled cf);
}
