package com.expressway.billmanagement.web.controllers.print;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expressway.billmanagement.report.api.IReportService;
import com.expressway.billmanagement.service.IMTCReportService;

/**
 * MTC日报、月报、年报打印
 * 
 * @author Ajaxfan
 */
@Controller
@RequestMapping(value = "services", method = { RequestMethod.GET })
public class MTCReportlPrintController extends BasePrintController {
    /** ETC数据服务 */
    private @Autowired IMTCReportService mtcReportService;
    /** 报表生成服务 */
    private @Autowired IReportService reportService;

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "etcDailyReport")
    public void etcDailyReport(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportType", "MTC日报");

        writeReportToClient(reportService.getPrintableObject(IReportService.MTC_REPORT, parameters,
                (List) mtcReportService.getDailyData(null)), response);
    }

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "etcMonthReport")
    public void etcMonthReport(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportType", "MTC月报");

        writeReportToClient(reportService.getPrintableObject(IReportService.MTC_REPORT, parameters,
                (List) mtcReportService.getMonthData(null)), response);
    }

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "etcYearReport")
    public void etcYearReport(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportType", "MTC年报");

        writeReportToClient(reportService.getPrintableObject(IReportService.MTC_REPORT, parameters,
                (List) mtcReportService.getYearData(null)), response);
    }
}
