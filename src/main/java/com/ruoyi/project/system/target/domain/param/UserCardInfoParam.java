package com.ruoyi.project.system.target.domain.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询是否唯一
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCardInfoParam {

    private String cardId;
    private String studyTitle;

    private String userId;
}
