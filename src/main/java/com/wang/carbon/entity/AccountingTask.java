package com.wang.carbon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-18 22:15
 */
@Data
@Api(value = "核算任务主体")
public class AccountingTask {

    @ApiModelProperty(value = "主键", required = true)
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "对应核算单元")
    private AccountingUnit accountingUnit;


}
