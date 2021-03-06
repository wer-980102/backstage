package com.ruoyi.project.system.target.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 每月消费流水对象 user_month_consumption_info
 *
 * @author wer
 * @date 2021-05-19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMonthConsumptionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long monthConsumptionId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 每月早间消费（元） */
    @Excel(name = "每月早间消费", readConverterExp = "元=")
    private Double monthMorning;

    /** 每月午间消费（元） */
    @Excel(name = "每月午间消费", readConverterExp = "元=")
    private Double monthNoon;

    /** 每月晚间消费（元） */
    @Excel(name = "每月晚间消费", readConverterExp = "元=")
    private Double monthNight;

    /** 每月其余消费（元） */
    @Excel(name = "每月其余消费", readConverterExp = "元=")
    private Double restConsumption;

    /** 每月总消费（元） */
    @Excel(name = "每月总消费", readConverterExp = "元=")
    private Double monthConsumption;

    /** 是否超过自己预期：0 是 1 否  */
    @Excel(name = "是否超过自己预期：0 是 1 否 ")
    private String consumptionStatus;

    /** 状态 0 是 1 否 */
    @Excel(name = "状态 0 是 1 否")
    private String status;

    /** 备注（钱的用向说明） */
    @Excel(name = "备注", readConverterExp = "钱=的用向说明")
    private String remarks;

    /** 月份  */
    @Excel(name = "月份", readConverterExp = "月份")
    private String monthValue;

}
