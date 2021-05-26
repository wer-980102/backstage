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
 * 每日消费流水对象 user_day_consumption_info
 *
 * @author wer
 * @date 2021-05-19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDayConsumptionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long dayConsumptionId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 早间消费（元） */
    @Excel(name = "早间消费", readConverterExp = "元=")
    private Integer dayMorning;

    /** 午间消费（元） */
    @Excel(name = "午间消费", readConverterExp = "元=")
    private Integer dayNoon;

    /** 晚间消费（元） */
    @Excel(name = "晚间消费", readConverterExp = "元=")
    private Integer dayNight;

    /** 其余消费（元） */
    @Excel(name = "其余消费", readConverterExp = "元=")
    private Integer restConsumption;

    /** 是否超过自己预期：0 是 1 否  */
    @Excel(name = "是否超过自己预期：0 是 1 否 ")
    private String consumptionStatus;

    /** 状态 0 是 1 否 */
    @Excel(name = "状态 0 是 1 否")
    private String status;

    /** 备注（钱的用向说明） */
    @Excel(name = "备注", readConverterExp = "钱=的用向说明")
    private String remarks;


    private String monthValue;
}
