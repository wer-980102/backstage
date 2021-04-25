package com.ruoyi.project.system.client.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 计算最后一次付款时间
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClerkSaleInfoDto {
    /** 用户ID**/
    private String customerId;

    /** 最后拿货时间**/
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private Date lastGoods;
}
