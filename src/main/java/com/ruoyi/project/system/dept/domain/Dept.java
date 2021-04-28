package com.ruoyi.project.system.dept.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 部门表 sys_dept
 *
 * @author ruoyi
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门ID */
    private Long deptId;

    /** 父部门ID */
    private Long parentId;

    /** 祖级列表 */
    private String ancestors;

    /** 部门名称 */
    private String deptName;

    /** 显示顺序 */
    private String orderNum;

    /** 负责人 */
    private String leader;

    /** 联系电话 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 部门状态:0正常,1停用 */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 父部门名称 */
    private String parentName;

    private Long userId;

    private String address;

    private String operator;
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private Date operatorTime;


}
