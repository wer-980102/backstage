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

    /** **/
    private String name;
    /** **/
    private String phoneNumber;
    /** **/
    private String memberType;
    /** **/
    private String customerType;
    /** **/
    private String actualSales;
    /** **/
    private String refundAmount;
    /** **/
    private String goodsFrequency;
    /** **/
    private String lastGoods;
    /** **/
    private String store;
    /** **/
    private String operatorTime;
    /** **/
    private String operator;

}
