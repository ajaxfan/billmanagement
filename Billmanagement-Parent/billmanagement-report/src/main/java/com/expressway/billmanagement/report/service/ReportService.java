package com.expressway.billmanagement.report.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressway.billmanagement.report.api.IReportCreator;
import com.expressway.billmanagement.report.api.IReportService;

import net.sf.jasperreports.engine.JasperPrint;

/**
 * 报表服务
 *
 * @author Ajaxfan
 */
@Service
final class ReportService implements IReportService {
    /** 三联单 */
    private @Autowired IReportCreator billThreeCreator;
    /** 票据使用明细 */
    private @Autowired IReportCreator billUseDetailCreator;
    /** 车流量 */
    private @Autowired IReportCreator carFlowCreator;
    /** ETC */
    private @Autowired IReportCreator etcreportCreator;
    /** MTC */
    private @Autowired IReportCreator mtcreportCreator;
    /** 免费车 */
    private @Autowired IReportCreator reductionReportCreator;
    /** 收费站车流 */
    private @Autowired IReportCreator tollGateCarFlowCreator;

    /**
     * @param reportType
     * @param parameters
     * @param list
     * @return
     */
    @Override
    public JasperPrint getPrintableObject(int reportType, Map<String, Object> parameters, List<Object> list) {
        switch (reportType) {
        case THREE_BILL:
            return billThreeCreator.create(parameters, list);
        case Bill_USE_DETAIL:
            return billUseDetailCreator.create(parameters, list);
        case CAR_FLOW:
            return carFlowCreator.create(parameters, list);
        case ETC_REPORT:
            return etcreportCreator.create(parameters, list);
        case MTC_REPORT:
            return mtcreportCreator.create(parameters, list);
        case REDUCTION_REPORT:
            return reductionReportCreator.create(parameters, list);
        case TOLL_GATE_CAR_FLOW:
            return tollGateCarFlowCreator.create(parameters, list);
        }
        return null;
    }

    /**
     * @param reportType
     * @param list
     * @return
     */
    @Override
    public JasperPrint getPrintableObject(int reportType, List<Object> list) {
        return getPrintableObject(reportType, new HashMap<String, Object>(), list);
    }
}
