package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.MTCReport;
import com.expressway.billmanagement.data.protocal.ConditionFiled;

/**
 * MTC车流量报表数据服务
 * 
 * @author Ajaxfan
 */
public interface IMTCReportService {
    /**
     * 单日数据统计
     * 
     * @param daily
     * @return
     */
    public List<MTCReport> getDailyData(ConditionFiled cf);

    /**
     * 月数据统计
     * 
     * @param month
     * @return
     */
    public List<MTCReport> getMonthData(ConditionFiled cf);

    /**
     * 年数据统计
     * 
     * @param year
     * @return
     */
    public List<MTCReport> getYearData(ConditionFiled cf);
}
