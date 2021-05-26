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
 * 运动信息对象 user_motion_info
 *
 * @author wer
 * @date 2021-05-19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMotionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long motionId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 运动时间（小时） */
    @Excel(name = "运动时间", readConverterExp = "小时")
    private String motionTime;

    /** 运动事项（如：俯卧撑等） */
    @Excel(name = "运动事项", readConverterExp = "如：俯卧撑等")
    private String motionDescribe;

    /** 饮食：1.标准 2.一般 3.不标准 */
    @Excel(name = "饮食")
    private String diet;

    /** 是否达到标准：0 是 1 否  */
    @Excel(name = "是否达到标准")
    private String standardStatus;

    /** 状态 0 是 1 否 */
    @Excel(name = "状态 0 是 1 否")
    private String status;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

}
