package com.expressway.billmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressway.billmanagement.data.mappers.MTCReportMapper;
import com.expressway.billmanagement.data.models.MTCReport;
import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.IMTCReportService;

@Service
public class MTCReportService implements IMTCReportService {
    private @Autowired MTCReportMapper mtcmapper;

    @Override
    public List<MTCReport> getDailyData(ConditionFiled cf) {
        return mtcmapper.findByCondition(cf);
    }

    @Override
    public List<MTCReport> getMonthData(ConditionFiled cf) {
        return mtcmapper.findByCondition(cf);
    }

    @Override
    public List<MTCReport> getYearData(ConditionFiled cf) {
        return mtcmapper.findByCondition(cf);
    }
}
