package com.geometry.servers.impl;

import com.geometry.mapper.NumberControlMapper;
import com.geometry.servers.INumberControlService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NumberControlServiceImpl implements INumberControlService {

    @Autowired
    private NumberControlMapper numberMapper;

    @Transactional
    public BigDecimal getMaxmum(String itemCode) throws DataAccessException {
        numberMapper.updateMaxmum(itemCode);
        BigDecimal num = numberMapper.selectMaxmum(itemCode);
        return num;
    }
}
