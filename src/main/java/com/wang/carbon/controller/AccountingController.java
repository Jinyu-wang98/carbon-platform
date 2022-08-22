package com.wang.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.carbon.common.R;
import com.wang.carbon.entity.AccountingEntity;
import com.wang.carbon.entity.AccountingUnit;
import com.wang.carbon.service.AccountingEntityService;
import com.wang.carbon.service.AccountingUnitService;
import com.wang.carbon.utils.Constant;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-10 21:10
 */
@Slf4j
@RestController
@RequestMapping("/carbon-host")
@Api(tags = "碳主体相关API")
public class AccountingController {
    @Autowired
    private AccountingEntityService accountingEntityService;

    @Autowired
    private AccountingUnitService accountingUnitService;

    @PostMapping("/accounting-entity")
    public R<String> save(@RequestBody AccountingEntity accountingEntity){
        log.info("新增核算主体：{}",accountingEntity.getName());

        accountingEntityService.save(accountingEntity);

        return R.success("新增核算主体成功");
    }

    /**
     * 核酸单元分页查询
     * @param page
     * @param pageSize
     * @param id
     * @return
     */
    @GetMapping("/accounting-unit/page")
    public R<Page> page(Long id,int page, int pageSize){
        log.info("id = {}, page = {},pageSize = {}" ,id, page, pageSize);

        //构造分页构造器
        Page pageInfo = new Page(page,pageSize);

        //构造条件构造器
        LambdaQueryWrapper<AccountingUnit> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(id.toString()),AccountingUnit::getCreateUser,id);
        //添加排序条件
        queryWrapper.orderByDesc(AccountingUnit::getUpdateTime);

        //执行查询
        accountingUnitService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 根据id修改核算单元信息
     * @param accountingUnit
     * @return
     */
    @PutMapping("/accounting-unit/")
    public R<String> update(@RequestBody AccountingUnit accountingUnit){
        log.info(accountingUnit.toString());
        accountingUnitService.updateById(accountingUnit);
        return R.success("核算单元修改成功");
    }

    /**
     * 根据id查询核算单元信息
     * @param id
     * @return
     */
    @GetMapping("/accounting-unit/{id}")
    public R<AccountingUnit> get(@PathVariable Long id){

        AccountingUnit accountingUnit = accountingUnitService.getById(id);

        return R.success(accountingUnit);
    }

    /**
     * 根据id删除核算单元
     * @param id
     * @return
     */
    @DeleteMapping("/accounting-unit/")
    public R<String> delete(Long id){
        log.info("删除核酸单元，id为：{}",id);
        accountingUnitService.remove(id);
        return R.success("核算单元删除成功");
    }

    /**
     * @description 查询核算单元最大数和当前使用数
     * @author
     * @param id
     * @createTime 2022/8/20 1:22
     * @return com.wang.carbon.common.R<java.lang.String>
     */

    @GetMapping("/accounting-unit/findUnitUsedCount")
    public R<String> findUnitUsedCount(Long id){
        int count = accountingUnitService.findUnitUsedCount(id);
        return R.success("allUnitTotal:" + Constant.unitAll+"usedUnitTotal:{}"+count);
    }



    



}
