package com.wang.carbon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-29 10:04
 */
@Data
public class Assets {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "手机号", required = true)
    private String phone;

    @ApiModelProperty(value = "当前资产总额", required = true)
    private String total;

    @ApiModelProperty(value = "可用资产总额", required = true)
    private String availableTotal;

    @ApiModelProperty(value = "冻结资产总额", required = true)
    private String freezeTotal;

    @ApiModelProperty(value = "资金资产", required = true)
    private String fund;

    @ApiModelProperty(value = "配额资产（吨）", required = true)
    private String quotaQty;

    @ApiModelProperty(value = "配额资产（元）", required = true)
    private String quotaFund;

    @ApiModelProperty(value = "CCER资产", required = true)
    private String ccer;











}
