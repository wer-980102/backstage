package com.ruoyi.project.system.client.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 门店数据对象 user_statistics_info
 *
 * @author ruoyi
 * @date 2021-04-16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @Excel(name = "操作时间")
    private String operatorTime;
    /**款号**/
    private String modelNumber;
    /**产品名称**/
    private String productName;
    /** 特殊用户**/
    private String specialUser;
    /** 开始时间**/
    private String startTime;
    /** 结束时间**/
    private String endTime;
    /** 销售Id**/
    private Long saleId;
}
