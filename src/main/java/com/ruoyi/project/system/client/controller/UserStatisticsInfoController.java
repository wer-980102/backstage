package com.ruoyi.project.system.client.controller;

import java.util.List;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.TimeUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.client.domain.*;
import com.ruoyi.project.system.client.domain.dto.ClerkSaleInfoDto;
import com.ruoyi.project.system.client.domain.dto.UserIntegralCalculationDto;
import com.ruoyi.project.system.client.domain.dto.UserIntegralInfoDto;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.domain.param.TimeInfoParam;
import com.ruoyi.project.system.client.service.IClerkSaleInfoService;
import com.ruoyi.project.system.client.service.IStatisticsInfoService;
import com.ruoyi.project.system.client.service.IUserIntegralInfoService;
import com.ruoyi.project.system.client.service.IUserStatisticsInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 门店数据Controller
 *
 * @author ruoyi
 * @date 2021-04-16
 */
@Controller
@RequestMapping("/system/client")
public class UserStatisticsInfoController extends BaseController
{
    private String prefix = "system/client";

    @Autowired
    private IUserStatisticsInfoService userStatisticsInfoService;
    @Autowired
    private IClerkSaleInfoService iClerkSaleInfoService;
    @Autowired
    private IUserIntegralInfoService   iUserIntegralInfoService;
    @Autowired
    private IUserStatisticsInfoService iUserStatisticsInfoService;
    @Autowired
    private IStatisticsInfoService iStatisticsInfoService;

    @GetMapping()
    public String info()
    {
        return prefix + "/client";
    }

    /**
     * 查询门店数据列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserStatisticsInfo userStatisticsInfo)
    {
        startPage();
        List<UserStatisticsInfoDto> list = null;
        //管理员查全部
        if(CommonUtils.USER_ADMIN.equals(ShiroUtils.getLoginName())){
            list = userStatisticsInfoService.selectUserStatisticsInfoList(userStatisticsInfo);
        }else{
            userStatisticsInfo.setUserId(ShiroUtils.getUserId());
            list = userStatisticsInfoService.selectUserStatisticsInfoList(userStatisticsInfo);

        }
        return getDataTable(list);
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<UserStatisticsInfo> util = new ExcelUtil<UserStatisticsInfo>(UserStatisticsInfo.class);
        return util.importTemplateExcel("后台数据");
    }

    /**
     * 导出门店数据列表
     */
    @Log(title = "门店数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserStatisticsInfo userStatisticsInfo)
    {
        List<UserStatisticsInfoDto> list = userStatisticsInfoService.selectUserStatisticsInfoList(userStatisticsInfo);
        ExcelUtil<UserStatisticsInfoDto> util = new ExcelUtil<UserStatisticsInfoDto>(UserStatisticsInfoDto.class);
        return util.exportExcel(list, "门店数据数据");
    }

    @Log(title = "用户管理导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<UserStatisticsInfo> util = new ExcelUtil<UserStatisticsInfo>(UserStatisticsInfo.class);
        List<UserStatisticsInfo> userList = util.importExcel(file.getInputStream());
        String message = userStatisticsInfoService.importUser(userList, updateSupport);
        return AjaxResult.success(message);
    }
    /**
     * 新增门店数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存门店数据
     */
    @Log(title = "门店数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserStatisticsInfo userStatisticsInfo)
    {
        return toAjax(userStatisticsInfoService.insertUserStatisticsInfo(userStatisticsInfo));
    }

    /**
     * 详情
     */
    @GetMapping("/edit/{statisticsId}")
    public String edit(@PathVariable("statisticsId") Long statisticsId, ModelMap mmap)
    {
        UserStatisticsInfoDto userStatisticsInfo = userStatisticsInfoService.selectUserStatisticsInfoById(statisticsId);
        mmap.put("userStatisticsInfo", userStatisticsInfo);
        return prefix + "/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detai/{statisticsId}")
    public String detai(@PathVariable("statisticsId") Long statisticsId, ModelMap mmap)
    {
        UserStatisticsInfoDto userStatisticsInfo = userStatisticsInfoService.selectUserStatisticsInfoById(statisticsId);
        mmap.put("userStatisticsInfo", userStatisticsInfo);
        return prefix + "/detai";
    }

    /**
     *  客户下销售纪录明细
     * @param userStatisticsInfo
     * @return
     */
    @PostMapping({"/userList"})
    @ResponseBody
    public TableDataInfo userList(UserStatisticsInfo userStatisticsInfo)
    {
        startPage();
        List<ClerkSaleInfo> list = this.iClerkSaleInfoService.getUserClerkSaleInfo(userStatisticsInfo.getStatisticsId().toString());
        return getDataTable(list);
    }

    /**
     * 升级用户
     */
    @ResponseBody
    @Log(title = "用户升级", businessType = BusinessType.UPDATE)
    @PostMapping("/specialUserEdit")
    public AjaxResult specialUserEdit(UserStatisticsInfo userStatisticsInfo)
    {
        String specialUserById = userStatisticsInfoService.getSpecialUserById(userStatisticsInfo.getStatisticsId());
        if(CommonUtils.SPECIAL_USER.equals(specialUserById)){
            return error("升级用户'" + userStatisticsInfo.getName() + "'失败，该用户已是特殊用户");
        }
        userStatisticsInfo.setSpecialUser(CommonUtils.SPECIAL_USER);
        return toAjax(userStatisticsInfoService.updateSpecialUserInfo(userStatisticsInfo));
    }

    /**
     * 一键减分
     */
    @ResponseBody
    @Log(title = "一键减分", businessType = BusinessType.UPDATE)
    @PostMapping("/scoreReduction")
    public AjaxResult ScoreReduction()
    {
        int i= 0;
        List<UserIntegralInfoDto> inactiveUserInfo = iClerkSaleInfoService.getInactiveUserInfo(TimeInfoParam.builder().startTime(TimeUtils.getMonthMinTime()).endTime(TimeUtils.getMonthMaxTime()).build());
       if(null != inactiveUserInfo){
           for (UserIntegralInfoDto dto : inactiveUserInfo){
               if(dto.getIntegral()>0){
                   i = iUserIntegralInfoService.updateUserIntegralInfo(UserIntegralInfo.builder().customerId(dto.getCustomerId()).integral(dto.getIntegral() - 1).build());
               }

           }
       }
        return toAjax(i);
    }

    /**
     * 一键计算积分
     */
    @ResponseBody
    @Log(title = "一键计算积分", businessType = BusinessType.UPDATE)
    @PostMapping("/scoreIntegral")
    public AjaxResult scoreIntegral()
    {
        int i = 0;
        List<UserStatisticsInfoDto> timingInfo = iUserStatisticsInfoService.getTimingInfo(TimeInfoParam.builder().startTime(TimeUtils.getMinTime()).endTime(TimeUtils.getMaxTime()).build());
        if(StringUtils.isNotNull(timingInfo)){
            timingInfo.stream().forEach(info->{

                //查询是否是新用户
                UserStatisticsInfo userInfo = iUserStatisticsInfoService.getUserById(info.getName());
                if(StringUtils.isNotNull(userInfo)){
                    //查询该老用户积分
                    UserIntegralCalculationDto integralCalculation = iUserStatisticsInfoService.getIntegralCalculation(TimeInfoParam.builder().customerId(userInfo.getStatisticsId()).build());
                    if(StringUtils.isNotNull(integralCalculation)){
                        UserIntegralInfo integralInfo = UserIntegralInfo.builder()
                                .customerId(Long.parseLong(info.getStatisticsId()))
                                .customerName(info.getName())
                                .integral(CommonUtils.getPlusIntegralInfo(integralCalculation.getIntegral(),info.getActualSales().intValue(),info.getGrade()))
                                .integralRule("规则就是不同等级的金额设置，比如第一级：金额为一万")
                                .integralRemark("第一级：>10000 +1或者<=10000 -1，第二级：>8000 +1或者<=8000 -1，第三级：>5000 +1或者<=5000 -1，第四级：>3000 +1或者<=3000 -1")
                                .changeSituation(CommonUtils.getIntegralJudge(info.getActualSales().intValue(),info.getGrade())+CommonUtils.PARAM)
                                .changeType(CommonUtils.getIntegralJudge(info.getActualSales().intValue(),info.getGrade()))
                                .changeName("本月活跃用户积分"+CommonUtils.getIntegralJudge(info.getActualSales().intValue(),info.getGrade())+CommonUtils.PARAM)
                                .operator(info.getOperator())
                                .operatorTime(info.getLastGoods()).build();
                        iUserIntegralInfoService.updateUserIntegralInfo(integralInfo);
                    }
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
                //计算等级
                UserStatisticsInfo statisticsInfo = new UserStatisticsInfo();
                if(info.getActualSales()>=10000){
                    statisticsInfo.setGrade("一级");
                }else if(info.getActualSales()>=8000 && info.getActualSales()<=9999){
                    statisticsInfo.setGrade("二级");
                }else if(info.getActualSales()>=5000 && info.getActualSales()<=7999){
                    statisticsInfo.setGrade("三级");
                }else{
                    statisticsInfo.setGrade("四级");
                }
                statisticsInfo.setStatisticsId(Long.parseLong(info.getStatisticsId()));
                iUserStatisticsInfoService.updateUserStatisticsGrade(statisticsInfo);
            });
            i++;
        }

        //统计所有额度值
        List<UserStatisticsInfoDto> statisticsInfoDtos = iUserStatisticsInfoService.getTimingSumInfo(TimeInfoParam.builder().startTime(TimeUtils.getMinTime()).endTime(TimeUtils.getMaxTime()).build());
        if(StringUtils.isNotNull(statisticsInfoDtos)){

            //每天定时插入
            statisticsInfoDtos.stream().forEach(statisticsInfo->{
                //查询是否存在该客户
                StatisticsInfo statisticsInfos = iStatisticsInfoService.getUserStatisticsInfo(statisticsInfo.getStatisticsId());
                if(StringUtils.isNotNull(statisticsInfos)){
                    StatisticsInfo info = StatisticsInfo.builder()
                            .customerId(Long.parseLong(statisticsInfo.getStatisticsId()))
                            .salesMonthValue(String.valueOf(Integer.valueOf(statisticsInfos.getSalesMonthValue())+Integer.valueOf(statisticsInfo.getSaleMonth())))
                            .refundAmountValue(String.valueOf(Integer.valueOf(statisticsInfos.getRefundAmountValue())+Integer.valueOf(statisticsInfo.getRefundAmount())))
                            .actualSalesValue(statisticsInfos.getActualSalesValue()+statisticsInfo.getActualSales())
                            .goodsFrequencyValue(String.valueOf(Integer.valueOf(statisticsInfos.getGoodsFrequencyValue())+Integer.valueOf(statisticsInfo.getGoodsFrequency()))).build();
                    ClerkSaleInfoDto lastGoodsInfo = iClerkSaleInfoService.getLastGoodsInfo(statisticsInfo.getStatisticsId());
                    //匹配拿货时间
                    if (StringUtils.isNotNull(lastGoodsInfo)) {
                        info.setLastGoods(lastGoodsInfo.getLastGoods());
                    }
                    iStatisticsInfoService.updateStatisticsInfo(info);
                }else {
                    StatisticsInfo info = StatisticsInfo.builder()
                            .customerId(Long.parseLong(statisticsInfo.getStatisticsId()))
                            .salesMonthValue(statisticsInfo.getSaleMonth())
                            .refundAmountValue(statisticsInfo.getRefundAmount())
                            .actualSalesValue(statisticsInfo.getActualSales())
                            .goodsFrequencyValue(statisticsInfo.getGoodsFrequency()).build();
                    ClerkSaleInfoDto lastGoodsInfo = iClerkSaleInfoService.getLastGoodsInfo(statisticsInfo.getStatisticsId());
                    //匹配拿货时间
                    if (StringUtils.isNotNull(lastGoodsInfo)) {
                        info.setLastGoods(lastGoodsInfo.getLastGoods());
                    }
                    iStatisticsInfoService.insertStatisticsInfo(info);
                }
            });
            i++;
        }

        //从销售纪录查询客户表没有的客户
        List<NotClerkSaleInfo> customerInfo = iUserStatisticsInfoService.getCustomerInfo(TimeInfoParam.builder().startTime(TimeUtils.getMinTime()).endTime(TimeUtils.getMaxTime()).build());
        if(StringUtils.isNotNull(customerInfo)){
            //每天定时插入
            customerInfo.stream().forEach(NotClerkSaleInfo->{
                UserStatisticsInfo statistics = UserStatisticsInfo.builder()
                        .name(NotClerkSaleInfo.getCustomer())
                        .store("部落")
                        .discount("1")
                        .customerType("零批客户")
                        .applicablePrice("无")
                        .residualIntegral("0")
                        .balance("0")
                        .specialUser("0")
                        .memberType("普通会员")
                        .quota("0")
                        .pickDays("0")
                        .operator("晓（18273261939）")
                        .operatorTime(TimeUtils.getMinTime()).build();
                if(NotClerkSaleInfo.getActualSales()>=10000){
                    statistics.setGrade("一级");
                }else if(NotClerkSaleInfo.getActualSales()>=8000 && NotClerkSaleInfo.getActualSales()<=9999){
                    statistics.setGrade("二级");
                }else if(NotClerkSaleInfo.getActualSales()>=5000 && NotClerkSaleInfo.getActualSales()<=7999){
                    statistics.setGrade("三级");
                }else{
                    statistics.setGrade("四级");
                }
                iUserStatisticsInfoService.insertUserStatisticsInfo(statistics);
            });
            i++;
        }

        return toAjax(i);
    }
    /**
     * 修改保存门店数据
     */
    @Log(title = "门店数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserStatisticsInfo userStatisticsInfo)
    {
        String specialUserById = userStatisticsInfoService.getSpecialUserById(userStatisticsInfo.getStatisticsId());
        if(CommonUtils.SPECIAL_USER.equals(specialUserById)){
            return error("修改用户'" + userStatisticsInfo.getName() + "'失败，该用户是特殊用户");
        }
        return toAjax(userStatisticsInfoService.updateUserStatisticsInfo(userStatisticsInfo));
    }

    /**
     * 修改会员数据
     */
    @Log(title = "修改会员数据", businessType = BusinessType.UPDATE)
    @PostMapping("/editUser")
    @ResponseBody
    public AjaxResult editUser(UserStatisticsInfo userStatisticsInfo)
    {
        return toAjax(userStatisticsInfoService.updateUserStatisticsMember(userStatisticsInfo));
    }

    /**
     * 删除门店数据
     */
    @Log(title = "门店数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userStatisticsInfoService.deleteUserStatisticsInfoByIds(ids));
    }
}
