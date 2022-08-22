package com.wang.carbon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-10 21:12
 */

@Data
@ApiModel(description = "核算主体信息")
public class AccountingEntity {

    @ApiModelProperty(value = "主键", required = true)
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "主体名称")
    public String name;

    @ApiModelProperty(value = "单位性质")
    public String companyType;

    @ApiModelProperty(value = "统一社会信用代码")
    public String socialCode;

    @ApiModelProperty(value = "排污许可证编号")
    public Long dischargeId;

    @ApiModelProperty(value = "法定代表人姓名")
    public String legalName;

    @ApiModelProperty(value = "注册日期")
    public LocalDateTime createTime;

    @ApiModelProperty(value = "注册资本")
    public String capital;

    @ApiModelProperty(value = "注册地址")
    public String address;

    @ApiModelProperty(value = "生产经营场所地址")
    public String productAddress;

    @ApiModelProperty(value = "邮编")
    public Long postalCode;

    @ApiModelProperty(value = "所属行业")
    public String industry;

    @ApiModelProperty(value = "报送主管部门")
    public String competentDepartment;

    @ApiModelProperty(value = "生产经营变化情况")
    public String changes;

    @ApiModelProperty(value = "联系人姓名")
    private String contactName;

    @ApiModelProperty(value = "联系电话")
    private String contactPhone;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

}
