package com.ruoyi.project.system.client.domain.dto;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStatisticsInfoDto extends BaseEntity {

    /** 客户ID**/
    private String statisticsId;
    /** 客户名称**/
    private String name;
    /** 手机号码**/
    private String phoneNumber;
    /** 客户等级**/
    private String memberType;
    /** 客户类型**/
    private String customerType;
    /** 累计销售月数**/
    private String saleMonth;
    /** 累计销售额**/
    private double actualSales;
    /**  累计实销数**/
    private String refundAmount;
    /** 累计拿货次数**/
    private String goodsFrequency;
    /** 最后拿货时间**/
    private String lastGoods;
    /** 分店名称**/
    private String store;
    /** 录入时间**/
    private String operatorTime;
    /** 操作人**/
    private String operator;
    /** 款号**/
    private String modelNumber;
    /** 产品名称**/
    private String productName;
    /** 特殊用户：将客户标识为特殊客户，特殊客户不受手动减分操作**/
    private String specialUser;
    /** 销售Id**/
    private String saleId;
}
