package com.ruoyi.project.system.client.domain.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeInfoParam {
    /** 开始时间**/
    private String startTime;
    /** 结束时间**/
    private String endTime;
}
