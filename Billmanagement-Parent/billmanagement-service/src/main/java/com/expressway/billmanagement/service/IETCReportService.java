package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.ETCReport;
import com.expressway.billmanagement.data.protocal.ConditionFiled;

/**
 * ETC车流量报表数据服务
 * 
 * @author Ajaxfan
 */
public interface IETCReportService {
    /**
     * 单日数据统计
     * 
     * @param daily
     * @return
     */
    public List<ETCReport> getDailyData(ConditionFiled cf);

    /**
     * 月数据统计
     * 
     * @param month
     * @return
     */
    public List<ETCReport> getMonthData(ConditionFiled cf);

    /**
     * 年数据统计
     * 
     * @param year
     * @return
     */
    public List<ETCReport> getYearData(ConditionFiled cf);
}
