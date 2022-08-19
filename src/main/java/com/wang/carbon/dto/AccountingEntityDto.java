package com.wang.carbon.dto;

import com.wang.carbon.entity.AccountingEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-18 22:39
 */
@ApiModel(value = "核算主体关联联系人信息")
public class AccountingEntityDto extends AccountingEntity {

    @ApiModelProperty(value = "联系人姓名")
    private String contactName;

    @ApiModelProperty(value = "联系电话")
    private String contactPhone;

    @ApiModelProperty(value = "电子邮箱")
    private String email;
}
