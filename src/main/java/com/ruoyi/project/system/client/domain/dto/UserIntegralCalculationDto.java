package com.ruoyi.project.system.client.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 计算等级信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserIntegralCalculationDto {

    /** 客户Id **/
    private Long statisticsId;
    /** 等级 **/
    private String grade;
    /** 积分 **/
    private Integer integral;
}
