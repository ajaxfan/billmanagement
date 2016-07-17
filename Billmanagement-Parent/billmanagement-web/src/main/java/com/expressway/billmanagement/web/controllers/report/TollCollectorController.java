package com.expressway.billmanagement.web.controllers.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.ITollCollectorService;

/**
 * 出入口收费员结算
 *
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = { RequestMethod.POST })
public class TollCollectorController {
    private @Autowired ITollCollectorService tollCollectorService;

    /**
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "inCollectorDataList")
    public Object inCollectorDataList(ConditionFiled cf) {
        List list = tollCollectorService.getInCollectorData(cf);

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
    @RequestMapping(value = "outCollectorDataList")
    public Object outCollectorDataList(ConditionFiled cf) {
        List list = tollCollectorService.getOutCollectorData(cf);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", list.size());// 记录总数
        map.put("items", list);// 记录行对象

        return map;
    }
}
