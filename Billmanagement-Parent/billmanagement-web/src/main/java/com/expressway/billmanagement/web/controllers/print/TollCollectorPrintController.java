package com.expressway.billmanagement.web.controllers.print;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expressway.billmanagement.report.api.IReportService;
import com.expressway.billmanagement.service.ITollCollectorService;

/**
 * 收费员出入口结算打印
 * 
 * @author Ajaxfan
 */
@Controller
@RequestMapping(value = "services", method = { RequestMethod.GET })
public class TollCollectorPrintController extends BasePrintController {
    /** 收费员出入口结算数据服务 */
    private @Autowired ITollCollectorService tollCollectorService;
    /** 报表生成服务 */
    private @Autowired IReportService reportService;

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "tollCollectorInReport")
    public void tollCollectorInReport(HttpServletRequest request, HttpServletResponse response) {
        writeReportToClient(reportService.getPrintableObject(IReportService.THREE_BILL,
                (List) tollCollectorService.getInCollectorData(null)), response);
    }

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "tollCollectorOutReport")
    public void tollCollectorOutReport(HttpServletRequest request, HttpServletResponse response) {
        writeReportToClient(reportService.getPrintableObject(IReportService.THREE_BILL,
                (List) tollCollectorService.getOutCollectorData(null)), response);
    }
}
