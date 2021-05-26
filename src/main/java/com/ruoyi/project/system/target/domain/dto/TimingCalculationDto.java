package com.ruoyi.project.system.target.domain.dto;

import lombok.Data;

/**
 * 定时计算
 */
@Data
public class TimingCalculationDto {

    private Double  dayMorning;

    private Double  dayNoon;

    private Double  dayNight;

    private Double  restConsumption;
}
