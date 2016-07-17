package com.expressway.billmanagement.web.controllers.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.IMTCReportService;

/**
 * MTC日报、月报、年报
 * 
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = { RequestMethod.POST })
public class MTCReportController {
    private @Autowired IMTCReportService mtcreportService;

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "mtcDailyDataList")
    public Object mtcDailyDataList(ConditionFiled cf) {
        List list = mtcreportService.getDailyData(cf);

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
    @RequestMapping(value = "mtcMonthDataList")
    public Object mtcMonthDataList(ConditionFiled cf) {
        List list = mtcreportService.getMonthData(cf);

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
    @RequestMapping(value = "mtcYearDataList")
    public Object mtcYearDataList(ConditionFiled cf) {
        List list = mtcreportService.getYearData(cf);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", list.size());// 记录总数
        map.put("items", list);// 记录行对象

        return map;
    }
}
