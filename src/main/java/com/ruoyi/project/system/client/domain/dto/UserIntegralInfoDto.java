package com.ruoyi.project.system.client.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 计算月份信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserIntegralInfoDto {
    /** 用户Id **/
    private Long customerId;
    /** 总积分 **/
    private Integer integral;
}
