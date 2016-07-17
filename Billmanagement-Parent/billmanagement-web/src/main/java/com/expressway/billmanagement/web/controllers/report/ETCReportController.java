package com.expressway.billmanagement.web.controllers.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.IETCReportService;

/**
 * ECT日报、年报、月报
 * 
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = { RequestMethod.POST })
public class ETCReportController {
    private @Autowired IETCReportService etcreportService;

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "etcDailyDataList")
    public Object etcDailyDataList(ConditionFiled cf) {
        List list = etcreportService.getDailyData(cf);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", list.size());// 记录总数
        map.put("items", list);// 记录行对象

        return map;
    }

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "etcMonthDataList")
    public Object etcMonthDataList(ConditionFiled cf) {
        List list = etcreportService.getMonthData(cf);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", list.size());// 记录总数
        map.put("items", list);// 记录行对象

        return map;
    }

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "etcYearDataList")
    public Object etcYearDataList(ConditionFiled cf) {
        List list = etcreportService.getYearData(cf);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", list.size());// 记录总数
        map.put("items", list);// 记录行对象

        return map;
    }
}
