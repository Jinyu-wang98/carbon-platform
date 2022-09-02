package com.wang.carbon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息
 */
@Data
@ApiModel(description = "人员信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "企业编码")
    private String companyId;


    @ApiModelProperty(value = "主键手机号", required = true)
    private String phone;

    @ApiModelProperty(value = "密码")
    private String password;
}
