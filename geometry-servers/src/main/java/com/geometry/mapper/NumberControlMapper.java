package com.geometry.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.math.BigDecimal;

@Mapper
public interface NumberControlMapper {

    BigDecimal selectMaxmum(String itemCode);

    void updateMaxmum(String itemCode);
}