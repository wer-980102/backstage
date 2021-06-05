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
 * 未注册人的销售纪录对象 not_clerk_sale_info
 *
 * @author wer
 * @date 2021-04-23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotClerkSaleInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long saleId;

    /** 款号 */
    @Excel(name = "款号")
    private String modelNumber;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 客户 */
    @Excel(name = "客户")
    private String customer;

    /** 用户ID */
    private Long userId;

    /** 销售数 */
    @Excel(name = "销售数")
    private String sales;

    /** 退货数 */
    @Excel(name = "退货数")
    private String store;

    /** 实销数 */
    @Excel(name = "实销数")
    private String refundAmount;

    /** 实销额 */
    @Excel(name = "实销额")
    private Integer actualSales;

    /** 最后一次拿货 */
    private String lastGoods;

    /** 拿货次数 */
    @Excel(name = "拿货次数")
    private String goodsFrequency;

    /** 开始时间**/
    private String startTime;
    /** 结束时间**/
    private String endTime;

}
