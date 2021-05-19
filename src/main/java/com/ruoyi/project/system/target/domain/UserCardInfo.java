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
 * 学习目标对象 user_card_info
 *
 * @author wer
 * @date 2021-05-19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCardInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long cardId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 学习标题 */
    @Excel(name = "学习标题")
    private String studyTitle;

    /** 学习目标 */
    @Excel(name = "学习目标")
    private String studyTarget;

    /** 准备时间（天） */
    @Excel(name = "准备时间", readConverterExp = "天=")
    private Integer preparationTime;

    /** 预达目标时间（天） */
    @Excel(name = "预达目标时间", readConverterExp = "天=")
    private Integer targetTime;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 目标状态 0 是 1 否 */
    @Excel(name = "目标状态 0 是 1 否")
    private String cardStatus;

    /** 状态 0 是 1 否 */
    @Excel(name = "状态 0 是 1 否")
    private String status;


}
