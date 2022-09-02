package com.wang.carbon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.carbon.common.CustomException;
import com.wang.carbon.entity.AccountingTask;
import com.wang.carbon.entity.AccountingUnit;
import com.wang.carbon.entity.AccountingUnitTask;
import com.wang.carbon.mapper.AccountingUnitMapper;
import com.wang.carbon.service.AccountingTaskService;
import com.wang.carbon.service.AccountingUnitService;
import com.wang.carbon.service.AccountingUnitTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-18 21:44
 */
@Service
public class AccountingUnitServiceImpl extends ServiceImpl<AccountingUnitMapper, AccountingUnit> implements AccountingUnitService {
    @Autowired
    private AccountingTaskService accountingTaskService;

    @Autowired
    private AccountingUnitService accountingUnitService;

    @Autowired
    private AccountingUnitTaskService accountingUnitTaskService;

    @Override
    public void remove(Long id){
        LambdaQueryWrapper<AccountingUnitTask>  lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        lambdaQueryWrapper.eq(AccountingUnitTask::getId, id);
        int count1 = accountingUnitTaskService.count(lambdaQueryWrapper);

        //查询当前单元是否关联了任务，如果已经关联，抛出一个业务异常
        if(count1 > 0){
            //已经关联菜品，抛出一个业务异常
            throw new CustomException("当前核算单元下关联了任务，不能删除");
        }
        //正常删除分类
        super.removeById(id);
    }

    @Override
    public int findUnitUsedCount(Long id) {
        LambdaQueryWrapper<AccountingUnit> accountingUnitLambdaQueryWrapper = new LambdaQueryWrapper<>();
        accountingUnitLambdaQueryWrapper.eq(AccountingUnit::getCreateUser, id);
        return this.count(accountingUnitLambdaQueryWrapper);
    }
}

