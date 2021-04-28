package com.ruoyi.project.system.timing;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.TimeUtils;
import com.ruoyi.project.system.client.domain.StatisticsInfo;
import com.ruoyi.project.system.client.domain.UserIntegralInfo;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.ClerkSaleInfoDto;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.domain.param.TimeInfoParam;
import com.ruoyi.project.system.client.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
     * 每天11:59:59同步统计数据
     */
    @Scheduled(cron = "${time.times}")
    @Transactional
    public void setDayStallSum() {
        System.out.println("......每天定时计算积分......");
        List<UserStatisticsInfoDto> timingInfo = iUserStatisticsInfoService.getTimingInfo(TimeInfoParam.builder().startTime(TimeUtils.getMinTime()).endTime(TimeUtils.getMaxTime()).build());
        if(StringUtils.isNotNull(timingInfo)){
            timingInfo.stream().forEach(info->{


                //查询是否是新用户
                UserStatisticsInfo userInfo = iUserStatisticsInfoService.getUserById(info.getName());
                if(StringUtils.isNotNull(userInfo)){
                    UserIntegralInfo integralInfo = UserIntegralInfo.builder()
                            .customerId(Long.parseLong(info.getStatisticsId()))
                            .customerName(info.getName())
                            .integral(CommonUtils.getPlusIntegralInfo(info.getActualSales().intValue()))
                            .integralRule("规则就是不同等级的金额设置，比如第一级：金额为一万")
                            .integralRemark("第一级：>10000 +1或者<=10000 -1，第二级：>8000 +1或者<=8000 -1，第三级：>5000 +1或者<=5000 -1，第四级：>3000 +1或者<=3000 -1")
                            .changeSituation(CommonUtils.getIntegralJudge(info.getActualSales().intValue())+CommonUtils.PARAM)
                            .changeType(CommonUtils.getIntegralJudge(info.getActualSales().intValue()))
                            .changeName("本月活跃用户积分"+CommonUtils.getIntegralJudge(info.getActualSales().intValue())+CommonUtils.PARAM)
                            .operator(info.getOperator())
                            .operatorTime(info.getLastGoods()).build();
                    iUserIntegralInfoService.updateUserIntegralInfo(integralInfo);

                }else{
                    //新用户默认10分
                    UserIntegralInfo integralInfo = UserIntegralInfo.builder()
                            .customerId(Long.parseLong(info.getStatisticsId()))
                            .customerName(info.getName())
                            .integral(10)
                            .integralRule("规则就是不同等级的金额设置，比如第一级：金额为一万")
                            .integralRemark("第一级：>10000 +1或者<=10000 -1，第二级：>8000 +1或者<=8000 -1，第三级：>5000 +1或者<=5000 -1，第四级：>3000 +1或者<=3000 -1")
                            .operator(info.getOperator())
                            .operatorTime(info.getLastGoods()).build();
                    iUserIntegralInfoService.insertUserIntegralInfo(integralInfo);
                }
            });
        }


        //统计所有额度值
        List<UserStatisticsInfoDto> statisticsInfoDtos = iUserStatisticsInfoService.getTimingSumInfo(TimeInfoParam.builder().startTime(TimeUtils.getMinTime()).endTime(TimeUtils.getMaxTime()).build());
        if(StringUtils.isNotNull(statisticsInfoDtos)){
            //每天定时插入
            statisticsInfoDtos.stream().forEach(statisticsInfo->{

                StatisticsInfo info = StatisticsInfo.builder()
                        .customerId(Long.parseLong(statisticsInfo.getStatisticsId()))
                        .salesMonthValue(statisticsInfo.getSaleMonth())
                        .refundAmountValue(statisticsInfo.getRefundAmount())
                        .actualSalesValue(statisticsInfo.getActualSales())
                        .goodsFrequencyValue(statisticsInfo.getGoodsFrequency()).build();
                ClerkSaleInfoDto lastGoodsInfo = iClerkSaleInfoService.getLastGoodsInfo(statisticsInfo.getStatisticsId());
                //匹配拿货时间
                if(StringUtils.isNotNull(lastGoodsInfo)){
                    info.setLastGoods(lastGoodsInfo.getLastGoods());
                }
                iStatisticsInfoService.insertStatisticsInfo(info);
            });
        }
    }
    /**
     * 初始化的时候计算积分
     */
    //@PostConstruct
    public void initStallSum() {
        System.out.println("......初始化定时计算积分......");
        List<UserStatisticsInfoDto> timingInfo = iUserStatisticsInfoService.getTimingInfo(new TimeInfoParam());
        if(null != timingInfo && timingInfo.size()>0){
            timingInfo.stream().forEach(info->{
                List<UserIntegralInfo> userIntegralInfos = iUserIntegralInfoService.selectUserIntegralInfoList(UserIntegralInfo.builder().customerId(Long.parseLong(info.getStatisticsId())).build());
                UserIntegralInfo integralInfo = UserIntegralInfo.builder()
                        .customerId(Long.parseLong(info.getStatisticsId()))
                        .customerName(info.getName())
                        .integral(CommonUtils.getPlusIntegralInfo(info.getActualSales().intValue()))
                        .integralRule("规则就是不同等级的金额设置，比如第一级：金额为一万")
                        .integralRemark("第一级：>10000 +1或者<=10000 -1，第二级：>8000 +1或者<=8000 -1，第三级：>5000 +1或者<=5000 -1，第四级：>3000 +1或者<=3000 -1")
                        .operator(info.getOperator())
                        .operatorTime(info.getLastGoods()).build();
                if(null != userIntegralInfos && userIntegralInfos.size()>0){
                    iUserIntegralInfoService.updateUserIntegralInfo(integralInfo);
                }else{
                    iUserIntegralInfoService.insertUserIntegralInfo(integralInfo);
                }
            });
        }

        //统计所有额度值
        List<UserStatisticsInfoDto> statisticsInfoDtos = iUserStatisticsInfoService.getTimingSumInfo(new TimeInfoParam());
        if(null != statisticsInfoDtos && statisticsInfoDtos.size()>0){
            //定时插入
            statisticsInfoDtos.stream().forEach(statisticsInfo->{
                StatisticsInfo infoCount = iStatisticsInfoService.selectStatisticsInfoById(Long.parseLong(statisticsInfo.getStatisticsId()));
                ClerkSaleInfoDto lastGoodsInfo = iClerkSaleInfoService.getLastGoodsInfo(statisticsInfo.getStatisticsId());
                StatisticsInfo info = StatisticsInfo.builder()
                        .customerId(Long.parseLong(statisticsInfo.getStatisticsId()))
                        .salesMonthValue(statisticsInfo.getSaleMonth())
                        .refundAmountValue(statisticsInfo.getRefundAmount())
                        .actualSalesValue(statisticsInfo.getActualSales())
                        .goodsFrequencyValue(statisticsInfo.getGoodsFrequency()).build();
                //匹配拿货时间
                if(StringUtils.isNotNull(lastGoodsInfo)){
                    info.setLastGoods(lastGoodsInfo.getLastGoods());
                }
                //判断统计表是否有该值
                if(StringUtils.isNotNull(infoCount)){
                    iStatisticsInfoService.updateStatisticsInfo(info);
                }else{
                    iStatisticsInfoService.insertStatisticsInfo(info);
                }

            });
        }

    }

}
