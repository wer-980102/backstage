package com.ruoyi.project.system.timing;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.project.system.client.domain.UserIntegralInfo;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
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
    private IUserStatisticsInfoService iUserStatisticsInfoService;
    @Autowired
    private IUserIntegralInfoService iUserIntegralInfoService;

    /**
     * 每天11:59:59同步统计数据
     */
    @Scheduled(cron = "${time.months}")
    public void setStallSum() {
        System.out.println("......每月定时计算积分......");
        List<UserStatisticsInfoDto> timingInfo = iUserStatisticsInfoService.getTimingInfo();
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
     * 初始化的时候计算积分
     */
    @PostConstruct
    public void initStallSum() {
        System.out.println("......初始化定时计算积分......");
        List<UserStatisticsInfoDto> timingInfo = iUserStatisticsInfoService.getTimingInfo();
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
    }
}
