package com.ruoyi.project.system.client.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 积分规则对象 user_integral_info
 *
 * @author wer
 * @date 2021-04-22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserIntegralInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long integralId;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long customerId;

    /** 客户 */
    @Excel(name = "客户")
    private String customerName;

    /** 总积分 */
    @Excel(name = "总积分")
    private Integer integral;

    /** 积分规则 */
    @Excel(name = "积分规则")
    private String integralRule;

    /** 规则描述 */
    @Excel(name = "规则描述")
    private String integralRemark;

    /** 积分变动情况 */
    @Excel(name = "积分变动情况")
    private String changeSituation;

    /** 积分变动类型 */
    @Excel(name = "积分变动类型")
    private String changeType;

    /** 积分变动名称 */
    @Excel(name = "积分变动名称")
    private String changeName;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 操作时间 */
    @Excel(name = "操作时间")
    private String operatorTime;

    /** 类型控制 */
    private Integer type;
}
