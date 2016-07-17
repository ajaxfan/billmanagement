package com.expressway.billmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressway.billmanagement.data.mappers.ReductionMapper;
import com.expressway.billmanagement.data.models.Reduction;
import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.IFreeCarService;

@Service
public class FreeCarService implements IFreeCarService {
    private @Autowired ReductionMapper reductionMapper;

    @Override
    public List<Reduction> getData(ConditionFiled cf) {
        return reductionMapper.findByCondition(cf);
    }
}
