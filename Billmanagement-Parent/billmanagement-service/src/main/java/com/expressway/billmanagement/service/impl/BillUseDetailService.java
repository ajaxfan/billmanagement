package com.expressway.billmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressway.billmanagement.data.mappers.BillUseDetailMapper;
import com.expressway.billmanagement.data.models.BillUseDetail;
import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.IBillUseDetailService;

@Service
public class BillUseDetailService implements IBillUseDetailService {
    private @Autowired BillUseDetailMapper billMapper;

    @Override
    public List<BillUseDetail> getData(ConditionFiled cf) {
        return billMapper.findByCondition(cf);
    }

}
