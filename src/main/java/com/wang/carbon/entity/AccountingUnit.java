package com.wang.carbon.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 11517
 * @Describe
 * @createTime 2022-08-18 21:31
 */
@Data
@ApiModel(description = "核算单元信息")
public class AccountingUnit {



    @ApiModelProperty(value = "主键", required = true)
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "核算单元名称")
    public String name;

    @ApiModelProperty(value = "所属组织")
    public String organization;

    @ApiModelProperty(value = "国民经济行业")
    public String economyIndustry;

    @ApiModelProperty(value = "核算指南行业")
    public String guideIndustry;

    @ApiModelProperty(value = "采用核算标准")
    public String standards;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private Long createUser;

    @ApiModelProperty(value = "修改人")
    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private Long updateUser;



}
