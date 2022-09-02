package com.wang.carbon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-18 13:56
 */
@Data
@ApiModel(description = "公司资质信息")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "企业编码", required = true)
    private Long companyId;

    @ApiModelProperty(value = "企业名称")
    private String companyName;

    @ApiModelProperty(value = "所属行业")
    private String industry;

    @ApiModelProperty(value = "联系人姓名")
    private String contactName;

    @ApiModelProperty(value = "部门")
    private String apartment;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "企业邮箱")
    private String email;
}
