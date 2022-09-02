package com.wang.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.carbon.common.R;
import com.wang.carbon.entity.AccountingTask;
import com.wang.carbon.service.AccountingTaskService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-18 21:50
 */
@Slf4j
@Api(tags = "碳核算相关API")
@RestController
@RequestMapping("/carbon-calculate")
public class CalculateController {

    @Autowired
    private AccountingTaskService accountingTaskService;
    /**
     * @description  新增任务
     * @author  wjy
     * @param accountingTask
     * @createTime 2022/8/24 16:11
     * @return R<java.lang.String>
     */
    @PostMapping("/task")
    public R<String> save(@RequestBody AccountingTask accountingTask){
        log.info("新增任务：{}",accountingTask.getTaskName());

        this.save(accountingTask);

        return R.success("新增任务成功");
    }


    @GetMapping("/page")
    public R<Page> page(int page, int pageSize,Long id){
        log.info("id = {}, page = {},pageSize = {}" ,id, page, pageSize);

        //构造分页构造器
        Page pageInfo = new Page(page,pageSize);

        //构造条件构造器
        LambdaQueryWrapper<AccountingTask> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(id.toString()),AccountingTask::getCreateUser,id);
        //添加排序条件
        queryWrapper.orderByDesc(AccountingTask::getUpdateTime);

        //执行查询
        accountingTaskService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 修改核算单元信息
     * @param accountingTask
     * @return
     */
    @PutMapping()
    public R<String> update(@RequestBody AccountingTask accountingTask){
        log.info(accountingTask.toString());
        accountingTaskService.updateById(accountingTask);
        return R.success("核算任务修改成功");
    }

    /**
     * 根据id查询核算单元信息
     * @param id
     * @return
     */
    @GetMapping()
    public R<AccountingTask> get(@PathVariable Long id){
        AccountingTask byId = accountingTaskService.getById(id);
        return R.success(byId);
    }

    /**
     * 删除核算单元
     * @param id
     * @return
     */
    @DeleteMapping()
    public R<String> delete(Long id){
        log.info("删除核算任务，id为：{}",id);
        accountingTaskService.removeById(id);
        return R.success("核算任务删除成功");
    }
}



