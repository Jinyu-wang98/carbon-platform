package com.wang.carbon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.carbon.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee>{
}
