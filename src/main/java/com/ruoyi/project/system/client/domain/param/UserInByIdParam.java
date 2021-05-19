package com.ruoyi.project.system.client.domain.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInByIdParam {

    /** 开始时间**/
    private String startTime;
    /** 姓名**/
    private String name;
    /** 电话号码**/
    private String phoneNumber;
}
