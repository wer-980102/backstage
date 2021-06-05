package com.ruoyi.project.system.client.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 【请填写功能名称】对象 statistics_info
 *
 * @author wer
 * @date 2021-04-23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id  */
    private Long statisticsId;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long customerId;

    /** 累计销售月数 */
    @Excel(name = "累计销售月数")
    private String salesMonthValue;

    /** 累计销售数 */
    @Excel(name = "累计销售数")
    private String salesValue;

    /** 累计退货数 */
    @Excel(name = "累计退货数")
    private String storeValue;

    /** 累计实销数 */
    @Excel(name = "累计实销数")
    private String refundAmountValue;

    /** 累计销售额 */
    @Excel(name = "累计销售额")
    private Double actualSalesValue;

    /** 累计拿货次数 */
    @Excel(name = "累计拿货次数")
    private String goodsFrequencyValue;

    /** 最后拿货时间**/
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private Date lastGoods;

    /** 用户ID**/
    @Excel(name = "用户ID")
    private Long userId;
}
