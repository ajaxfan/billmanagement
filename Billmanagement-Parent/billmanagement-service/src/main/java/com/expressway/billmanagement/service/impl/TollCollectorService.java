package com.expressway.billmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressway.billmanagement.data.mappers.BillThreeMapper;
import com.expressway.billmanagement.data.models.BillThree;
import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.ITollCollectorService;

@Service
public class TollCollectorService implements ITollCollectorService {
    private @Autowired BillThreeMapper billthreeMapper;

    @Override
    public List<BillThree> getInCollectorData(ConditionFiled cf) {
        return billthreeMapper.findByCondition(cf);
    }

    @Override
    public List<BillThree> getOutCollectorData(ConditionFiled cf) {
        return billthreeMapper.findByCondition(cf);
    }
}
