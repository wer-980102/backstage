package com.ruoyi.project.system.target.domain.dto;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import lombok.Data;

/**
 * 学习进度
 */
@Data
public class LogRecodeInfoDto {

    @Excel(name = "进度ID")
    private String  recodeId;
    @Excel(name = "目标ID")
    private String  cardId;
    @Excel(name = "学习类目")
    private String  studyCategory;
    @Excel(name = "今日状态")
    private String  studyStatus;
    @Excel(name = "学习时间")
    private String  studyTime;
    @Excel(name = "是否达到自己预期")
    private String  studyExpect;
    @Excel(name = "学习标题")
    private String  studyTitle;
    @Excel(name = "准备时间")
    private String  preparationTime;
    @Excel(name = "预达目标时间")
    private String  targetTime;
    @Excel(name = "创建时间")
    private String createTime;
}
