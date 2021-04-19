package com.ruoyi.project.system.client.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 销售纪录对象 clerk_sale_info
 *
 * @author ruoyi
 * @date 2021-04-16
 */
public class ClerkSaleInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long saleId;

    /** 款号 */
    @Excel(name = "款号")
    private String modelNumber;

    /** 产品名称 */
    @Excel(name = "名称")
    private String productName;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 客户ID */
    private Long customerId;

    /** 客户 */
    @Excel(name = "客户")
    private String customer;

    /** 销售数 */
    @Excel(name = "销售数")
    private String sales;

    /** 退款数 */
    @Excel(name = "退货数")
    private String store;

    /** 实销数 */
    @Excel(name = "实销数")
    private String refundAmount;

    /** 实销额 */
    @Excel(name = "实销额 ")
    private String actualSales;

    /** 最后一次拿货 */
    @Excel(name = "最后一次拿货")
    private String lastGoods;

    /** 拿货次数 */
    @Excel(name = "拿货次数")
    private String goodsFrequency;

    public void setSaleId(Long saleId)
    {
        this.saleId = saleId;
    }

    public Long getSaleId()
    {
        return saleId;
    }
    public void setModelNumber(String modelNumber)
    {
        this.modelNumber = modelNumber;
    }

    public String getModelNumber()
    {
        return modelNumber;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductName()
    {
        return productName;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setCustomerId(Long customerId)
    {
        this.customerId = customerId;
    }

    public Long getCustomerId()
    {
        return customerId;
    }
    public void setCustomer(String customer)
    {
        this.customer = customer;
    }

    public String getCustomer()
    {
        return customer;
    }
    public void setSales(String sales)
    {
        this.sales = sales;
    }

    public String getSales()
    {
        return sales;
    }
    public void setStore(String store)
    {
        this.store = store;
    }

    public String getStore()
    {
        return store;
    }
    public void setRefundAmount(String refundAmount)
    {
        this.refundAmount = refundAmount;
    }

    public String getRefundAmount()
    {
        return refundAmount;
    }
    public void setActualSales(String actualSales)
    {
        this.actualSales = actualSales;
    }

    public String getActualSales()
    {
        return actualSales;
    }
    public void setLastGoods(String lastGoods)
    {
        this.lastGoods = lastGoods;
    }

    public String getLastGoods()
    {
        return lastGoods;
    }
    public void setGoodsFrequency(String goodsFrequency)
    {
        this.goodsFrequency = goodsFrequency;
    }

    public String getGoodsFrequency()
    {
        return goodsFrequency;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("saleId", getSaleId())
            .append("modelNumber", getModelNumber())
            .append("productName", getProductName())
            .append("brand", getBrand())
            .append("customerId", getCustomerId())
            .append("customer", getCustomer())
            .append("sales", getSales())
            .append("store", getStore())
            .append("refundAmount", getRefundAmount())
            .append("actualSales", getActualSales())
            .append("lastGoods", getLastGoods())
            .append("goodsFrequency", getGoodsFrequency())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
