package com.wang.carbon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.carbon.entity.Company;
import com.wang.carbon.mapper.CompanyMapper;
import com.wang.carbon.service.CompanyService;
import org.springframework.stereotype.Service;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-18 14:31
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
}
