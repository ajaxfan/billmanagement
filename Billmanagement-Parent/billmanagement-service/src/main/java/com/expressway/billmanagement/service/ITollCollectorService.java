package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.BillThree;
import com.expressway.billmanagement.data.protocal.ConditionFiled;

/**
 * 收费员结算统计
 * 
 * @author Ajaxfan
 */
public interface ITollCollectorService {
    /**
     * 入口收费员结算
     * 
     * @param cf
     * @return
     */
    public List<BillThree> getInCollectorData(ConditionFiled cf);

    /**
     * 出口收费员结算
     * 
     * @param cf
     * @return
     */
    public List<BillThree> getOutCollectorData(ConditionFiled cf);
}
