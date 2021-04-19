package com.ruoyi.project.system.client.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 门店数据对象 user_statistics_info
 *
 * @author ruoyi
 * @date 2021-04-16
 */
public class UserStatisticsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long statisticsId;

    /** 用户名 */
    @Excel(name = "名称")
    private String name;

    /** 手机号码 */
    @Excel(name = "手机号")
    private String phoneNumber;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 备注 */
    @Excel(name = "备注")
    private String storeRemark;

    /** 区域 */
    @Excel(name = "区域")
    private String region;

    /** 门店 */
    @Excel(name = "门店")
    private String store;

    /** 店员 */
    @Excel(name = "店员")
    private String clerk;

    /** 代码 */
    @Excel(name = "代码")
    private String code;

    /** 折扣 */
    @Excel(name = "折扣")
    private String discount;

    /** 固定优惠 */
    @Excel(name = "固定优惠")
    private String fixedOffer;

    /** 传真号 */
    @Excel(name = "传真号")
    private String faxNumber;

    /** 类型：1.零批客户 */
    @Excel(name = "类型")
    private String customerType;

    /** 适用价格 */
    @Excel(name = "适用价格")
    private String applicablePrice;

    /** 生日 */
    @Excel(name = "生日")
    private String birthday;

    /** 剩余积分 */
    @Excel(name = "剩余积分")
    private String residualIntegral;

    /** 余额 */
    @Excel(name = "余额")
    private String balance;

    /** 上级客户 */
    @Excel(name = "上级客户")
    private String parentCustomer;

    /** 等级类型：1.普通会员 */
    @Excel(name = "等级")
    private String memberType;

    /** 信用额度 */
    @Excel(name = "信用额度")
    private String quota;

    /** 最后拿货天数 */
    @Excel(name = "最后拿货天数")
    private String pickDays;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date operatorTime;

    public void setStatisticsId(Long statisticsId)
    {
        this.statisticsId = statisticsId;
    }

    public Long getStatisticsId()
    {
        return statisticsId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setStoreRemark(String storeRemark)
    {
        this.storeRemark = storeRemark;
    }

    public String getStoreRemark()
    {
        return storeRemark;
    }
    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getRegion()
    {
        return region;
    }
    public void setStore(String store)
    {
        this.store = store;
    }

    public String getStore()
    {
        return store;
    }
    public void setClerk(String clerk)
    {
        this.clerk = clerk;
    }

    public String getClerk()
    {
        return clerk;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setDiscount(String discount)
    {
        this.discount = discount;
    }

    public String getDiscount()
    {
        return discount;
    }
    public void setFixedOffer(String fixedOffer)
    {
        this.fixedOffer = fixedOffer;
    }

    public String getFixedOffer()
    {
        return fixedOffer;
    }
    public void setFaxNumber(String faxNumber)
    {
        this.faxNumber = faxNumber;
    }

    public String getFaxNumber()
    {
        return faxNumber;
    }
    public void setCustomerType(String customerType)
    {
        this.customerType = customerType;
    }

    public String getCustomerType()
    {
        return customerType;
    }
    public void setApplicablePrice(String applicablePrice)
    {
        this.applicablePrice = applicablePrice;
    }

    public String getApplicablePrice()
    {
        return applicablePrice;
    }
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getBirthday()
    {
        return birthday;
    }
    public void setResidualIntegral(String residualIntegral)
    {
        this.residualIntegral = residualIntegral;
    }

    public String getResidualIntegral()
    {
        return residualIntegral;
    }
    public void setBalance(String balance)
    {
        this.balance = balance;
    }

    public String getBalance()
    {
        return balance;
    }
    public void setParentCustomer(String parentCustomer)
    {
        this.parentCustomer = parentCustomer;
    }

    public String getParentCustomer()
    {
        return parentCustomer;
    }
    public void setMemberType(String memberType)
    {
        this.memberType = memberType;
    }

    public String getMemberType()
    {
        return memberType;
    }
    public void setPickDays(String pickDays)
    {
        this.pickDays = pickDays;
    }

    public String getPickDays()
    {
        return pickDays;
    }
    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getOperator()
    {
        return operator;
    }
    public void setOperatorTime(Date operatorTime)
    {
        this.operatorTime = operatorTime;
    }

    public Date getOperatorTime()
    {
        return operatorTime;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("statisticsId", getStatisticsId())
            .append("name", getName())
            .append("phoneNumber", getPhoneNumber())
            .append("address", getAddress())
            .append("storeRemark", getStoreRemark())
            .append("region", getRegion())
            .append("store", getStore())
            .append("clerk", getClerk())
            .append("code", getCode())
            .append("discount", getDiscount())
            .append("fixedOffer", getFixedOffer())
            .append("faxNumber", getFaxNumber())
            .append("customerType", getCustomerType())
            .append("applicablePrice", getApplicablePrice())
            .append("birthday", getBirthday())
            .append("residualIntegral", getResidualIntegral())
            .append("balance", getBalance())
            .append("parentCustomer", getParentCustomer())
            .append("memberType", getMemberType())
            .append("quota", getQuota())
            .append("pickDays", getPickDays())
            .append("operator", getOperator())
            .append("operatorTime", getOperatorTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
