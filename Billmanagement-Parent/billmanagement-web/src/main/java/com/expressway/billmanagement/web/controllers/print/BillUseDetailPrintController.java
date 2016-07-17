package com.expressway.billmanagement.web.controllers.print;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expressway.billmanagement.report.api.IReportService;
import com.expressway.billmanagement.service.IBillUseDetailService;

/**
 * 报表使用明细打印
 * 
 * @author Ajaxfan
 */
@Controller
@RequestMapping(value = "services", method = { RequestMethod.GET })
public class BillUseDetailPrintController extends BasePrintController {
    /** 票据使用明细数据服务 */
    private @Autowired IBillUseDetailService billUseDetailService;
    /** 报表生成服务 */
    private @Autowired IReportService reportService;

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "billUseDetailReport")
    public void billUseDetailReport(HttpServletRequest request, HttpServletResponse response) {
        writeReportToClient(reportService.getPrintableObject(IReportService.Bill_USE_DETAIL,
                (List) billUseDetailService.getData(null)), response);
    }
}
