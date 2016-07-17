package com.expressway.billmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressway.billmanagement.data.mappers.ETCReportMapper;
import com.expressway.billmanagement.data.models.ETCReport;
import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.IETCReportService;

/**
 * ETC报表统计服务
 * 
 * @author Ajaxfan
 */
@Service
final class ETCReportService implements IETCReportService {
    private @Autowired ETCReportMapper etcmapper;

    @Override
    public List<ETCReport> getDailyData(ConditionFiled cf) {
        return etcmapper.findByCondition(cf);
    }

    @Override
    public List<ETCReport> getMonthData(ConditionFiled cf) {
        return etcmapper.findByCondition(cf);
    }

    @Override
    public List<ETCReport> getYearData(ConditionFiled cf) {
        return etcmapper.findByCondition(cf);
    }
}
