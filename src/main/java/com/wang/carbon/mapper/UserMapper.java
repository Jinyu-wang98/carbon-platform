package com.wang.carbon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.carbon.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{
}
