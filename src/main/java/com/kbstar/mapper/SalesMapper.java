package com.kbstar.mapper;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Sales;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Mapper
public interface SalesMapper extends KBMapper<Date, Sales> {
}
