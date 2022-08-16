package com.wang.carbon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.carbon.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}