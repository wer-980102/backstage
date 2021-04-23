package com.ruoyi.project.system.client.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

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
    private String actualSalesValue;

    /** 累计拿货次数 */
    @Excel(name = "累计拿货次数")
    private String goodsFrequencyValue;


}
