package com.wang.carbon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.carbon.entity.AccountingEntity;
import com.wang.carbon.entity.AccountingUnit;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-18 21:43
 */
public interface AccountingUnitService extends IService<AccountingUnit> {

    void remove(Long id);

    int findUnitUsedCount(Long id);
}
