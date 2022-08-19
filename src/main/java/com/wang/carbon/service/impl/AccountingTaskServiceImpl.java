package com.wang.carbon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.carbon.entity.AccountingTask;
import com.wang.carbon.entity.AccountingUnit;
import com.wang.carbon.mapper.AccountingTaskMapper;
import com.wang.carbon.service.AccountingTaskService;
import org.springframework.stereotype.Service;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-20 00:46
 */
@Service
public class AccountingTaskServiceImpl extends ServiceImpl<AccountingTaskMapper, AccountingTask> implements AccountingTaskService {

}

