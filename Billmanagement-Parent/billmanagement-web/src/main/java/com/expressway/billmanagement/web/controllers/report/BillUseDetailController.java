package com.expressway.billmanagement.web.controllers.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.IBillUseDetailService;

/**
 * 票据使用明细
 * 
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = { RequestMethod.POST })
public class BillUseDetailController {
    private @Autowired IBillUseDetailService billUseDetailService;

    /**
     * 坏卡
     *
     * @param limit
     *            开始索引
     * @param start
     *            结束索引
     * @return
     */
    @RequestMapping(value = "billUseDetailList")
    public Object billUseDetailList(ConditionFiled cf) {
        List list = billUseDetailService.getData(cf);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", list);// 记录总数
        map.put("items", list.size());// 记录行对象

        return map;
    }
}
