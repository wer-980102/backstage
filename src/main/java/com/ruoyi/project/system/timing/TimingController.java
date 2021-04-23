package com.ruoyi.project.system.timing;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.TimeUtils;
import com.ruoyi.project.system.client.domain.StatisticsInfo;
import com.ruoyi.project.system.client.domain.UserIntegralInfo;
import com.ruoyi.project.system.client.domain.dto.UserMonthInfoDto;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.domain.param.TimeInfoParam;
import com.ruoyi.project.system.client.service.IClerkSaleInfoService;
import com.ruoyi.project.system.client.service.IStatisticsInfoService;
import com.ruoyi.project.system.client.service.IUserIntegralInfoService;
import com.ruoyi.project.system.client.service.IUserStatisticsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 定时
 */
@Component
public class TimingController {

    @Autowired
    private IClerkSaleInfoService iClerkSaleInfoService;
    @Autowired
    private IStatisticsInfoService iStatisticsInfoService;
    @Autowired
    private IUserStatisticsInfoService iUserStatisticsInfoService;
    @Autowired
    private IUserIntegralInfoService iUserIntegralInfoService;

    /**
     * 每月11:59:59同步统计数据
     */
    @Scheduled(cron = "${time.months}")
    public void setMonthStallSum() {
        System.out.println("......每月定时计算积分......");
        List<UserStatisticsInfoDto> timingInfo = iUserStatisticsInfoService.getTimingInfo(TimeInfoParam.builder().startTime(TimeUtils.getMonthMinTime()).endTime(TimeUtils.getMonthMaxTime()).build());
        timingInfo.stream().forEach(info->{
            UserIntegralInfo integralInfo = UserIntegralInfo.builder()
                    .customerId(Long.parseLong(info.getStatisticsId()))
                    .customerName(info.getName())
                    .integral(CommonUtils.getPlusIntegralInfo(info.getActualSales().intValue()))
                    .integralRule("")
                    .integralRemark("")
                    .changeSituation("")
                    .changeType("")
                    .changeName("")
                    .operator(info.getOperator())
                    .operatorTime(info.getLastGoods()).build();
            iUserIntegralInfoService.updateUserIntegralInfo(integralInfo);
        });
    }
    /**
     * 每天11:59:59同步统计数据
     */
    @Scheduled(cron = "${time.times}")
    public void setDayStallSum() {
        System.out.println("......每天定时计算积分......");
        List<UserStatisticsInfoDto> timingInfo = iUserStatisticsInfoService.getTimingInfo(TimeInfoParam.builder().startTime(TimeUtils.getMinTime()).endTime(TimeUtils.getMaxTime()).build());
        timingInfo.stream().forEach(info->{
            UserIntegralInfo integralInfo = UserIntegralInfo.builder()
                    .customerId(Long.parseLong(info.getStatisticsId()))
                    .customerName(info.getName())
                    .integral(CommonUtils.getPlusIntegralInfo(info.getActualSales().intValue()))
                    .integralRule("")
                    .integralRemark("")
                    .changeSituation("")
                    .changeType("")
                    .changeName("")
                    .operator(info.getOperator())
                    .operatorTime(info.getLastGoods()).build();
            iUserIntegralInfoService.updateUserIntegralInfo(integralInfo);
        });

        //统计所有额度值
        List<UserStatisticsInfoDto> statisticsInfoDtos = iUserStatisticsInfoService.getTimingSumInfo(TimeInfoParam.builder().startTime(TimeUtils.getMinTime()).endTime(TimeUtils.getMaxTime()).build());
        //每天定时插入
        statisticsInfoDtos.stream().forEach(statisticsInfo->{
            iStatisticsInfoService.insertStatisticsInfo(StatisticsInfo.builder()
                                        .statisticsId(Long.parseLong(statisticsInfo.getStatisticsId()))
                                        .salesMonthValue(statisticsInfo.getSaleMonth())
                                        .refundAmountValue(statisticsInfo.getRefundAmount())
                                        .actualSalesValue(statisticsInfo.getActualSales().toString())
                                        .goodsFrequencyValue(statisticsInfo.getGoodsFrequency()).build());
        });
    }
    /**
     * 初始化的时候计算积分
     */
   // @PostConstruct
    public void initStallSum() {
        System.out.println("......初始化定时计算积分......");
        List<UserStatisticsInfoDto> timingInfo = iUserStatisticsInfoService.getTimingInfo(new TimeInfoParam());
        timingInfo.stream().forEach(info->{
            List<UserIntegralInfo> userIntegralInfos = iUserIntegralInfoService.selectUserIntegralInfoList(UserIntegralInfo.builder().customerId(Long.parseLong(info.getStatisticsId())).build());
            UserIntegralInfo integralInfo = UserIntegralInfo.builder()
                    .customerId(Long.parseLong(info.getStatisticsId()))
                    .customerName(info.getName())
                    .integral(CommonUtils.getPlusIntegralInfo(info.getActualSales().intValue()))
/*                    .integralRule("")
                    .integralRemark("")
                    .changeSituation("")
                    .changeType("")
                    .changeName("")*/
                    .operator(info.getOperator())
                    .operatorTime(info.getLastGoods()).build();
            if(null != userIntegralInfos && userIntegralInfos.size()>0){
                iUserIntegralInfoService.updateUserIntegralInfo(integralInfo);
            }else{
                iUserIntegralInfoService.insertUserIntegralInfo(integralInfo);
            }
        });

        //统计所有额度值
        List<UserStatisticsInfoDto> statisticsInfoDtos = iUserStatisticsInfoService.getTimingSumInfo(new TimeInfoParam());
        //每天定时插入
        statisticsInfoDtos.stream().forEach(statisticsInfo->{
            List<UserIntegralInfo> userIntegralInfos = iUserIntegralInfoService.selectUserIntegralInfoList(UserIntegralInfo.builder().customerId(Long.parseLong(statisticsInfo.getStatisticsId())).build());
            StatisticsInfo info = StatisticsInfo.builder()
                    .statisticsId(Long.parseLong(statisticsInfo.getStatisticsId()))
                    .salesMonthValue(statisticsInfo.getSaleMonth())
                    .refundAmountValue(statisticsInfo.getRefundAmount())
                    .actualSalesValue(statisticsInfo.getActualSales().toString())
                    .goodsFrequencyValue(statisticsInfo.getGoodsFrequency()).build();
            if(null != userIntegralInfos && userIntegralInfos.size()>0){
                iStatisticsInfoService.insertStatisticsInfo(info);
            }else{
                iStatisticsInfoService.updateStatisticsInfo(info);
            }

        });
    }
}
