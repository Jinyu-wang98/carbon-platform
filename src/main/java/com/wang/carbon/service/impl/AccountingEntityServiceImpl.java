package com.wang.carbon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.carbon.dto.AccountingEntityDto;
import com.wang.carbon.entity.AccountingEntity;
import com.wang.carbon.mapper.AccountingEntityMapper;
import com.wang.carbon.service.AccountingEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-18 21:44
 */
@Service
public class AccountingEntityServiceImpl extends ServiceImpl<AccountingEntityMapper, AccountingEntity> implements AccountingEntityService {

}
