package com.wang.carbon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.carbon.entity.Assets;
import com.wang.carbon.mapper.AssetsMapper;
import com.wang.carbon.service.AssetsService;
import org.springframework.stereotype.Service;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-09-02 16:58
 */
@Service
public class AssetsServiceImpl extends ServiceImpl<AssetsMapper, Assets> implements AssetsService {
}
