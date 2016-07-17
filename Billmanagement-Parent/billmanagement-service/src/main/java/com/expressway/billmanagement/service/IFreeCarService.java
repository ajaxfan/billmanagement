package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.Reduction;
import com.expressway.billmanagement.data.protocal.ConditionFiled;

/**
 * 减免车辆统计
 * @author Ajaxfan
 */
public interface IFreeCarService {
    public List<Reduction> getData(ConditionFiled cf);
}
