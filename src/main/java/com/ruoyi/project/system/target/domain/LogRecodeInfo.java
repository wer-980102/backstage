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
 * 目标进行对象 log_recode_info
 *
 * @author wer
 * @date 2021-05-19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogRecodeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long recodeId;

    /** 目标ID */
    @Excel(name = "目标ID")
    private Long cardId;

    /** 学习类目 */
    @Excel(name = "学习类目")
    private String studyCategory;

    /** 今日状态: 1.一般 2.还行 3.很好 4.不学习会死 */
    @Excel(name = "今日状态: 1.一般 2.还行 3.很好 4.不学习会死")
    private String studyStatus;

    /** 学习时间（小时） */
    @Excel(name = "学习时间", readConverterExp = "小=时")
    private Integer studyTime;

    /** 是否达到自己预期：0 是 1 否  */
    @Excel(name = "是否达到自己预期：0 是 1 否 ")
    private String studyExpect;

    /** 状态 0 是 1 否 */
    @Excel(name = "状态 0 是 1 否")
    private String status;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;


}
