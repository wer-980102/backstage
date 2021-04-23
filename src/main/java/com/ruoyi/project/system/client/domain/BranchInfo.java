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
 * 分店信息对象 branch_info
 *
 * @author wer
 * @date 2021-04-23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long branchId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 分店名称 */
    @Excel(name = "分店名称")
    private String branchName;

    /** 分店地址 */
    @Excel(name = "分店地址")
    private String address;

    /** 负责人名称 */
    @Excel(name = "负责人名称")
    private String chargeName;

    /** 负责人联系方式 */
    @Excel(name = "负责人联系方式")
    private String information;

    /** 分店状态 */
    @Excel(name = "分店状态")
    private String status;

    /** 录入人 */
    @Excel(name = "录入人")
    private String operator;

    /** 录入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "录入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operatorTime;


}
