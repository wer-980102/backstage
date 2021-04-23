package com.ruoyi.project.system.client.domain.dto;

import com.ruoyi.framework.web.domain.BaseEntity;
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
public class UserMonthInfoDto extends BaseEntity {
    /** 用户ID**/
    private String customerId;
    /** 月份次数**/
    private String lastGoodsCount;
}
