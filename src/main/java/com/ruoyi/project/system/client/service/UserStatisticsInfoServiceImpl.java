package com.ruoyi.project.system.client.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.TimeUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.client.domain.*;
import com.ruoyi.project.system.client.domain.dto.UserIntegralCalculationDto;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.domain.param.TimeInfoParam;
import com.ruoyi.project.system.client.domain.param.UserInByIdParam;
import com.ruoyi.project.system.client.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 门店数据Service业务层处理
 *
 * @author wer
 * @date 2021-04-16
 */
@Service
public class UserStatisticsInfoServiceImpl implements IUserStatisticsInfoService
{

    private static final Logger log = LoggerFactory.getLogger(UserStatisticsInfoServiceImpl.class);

    @Autowired
    private BranchInfoMapper branchInfoMapper;

    @Autowired
    private StatisticsInfoMapper statisticsInfoMapper;

    @Autowired
    private UserStatisticsInfoMapper userStatisticsInfoMapper;

    @Autowired
    private ClerkSaleInfoMapper clerkSaleInfoMapper;

    @Autowired
    private NotClerkSaleInfoMapper notClerkSaleInfoMapper;
    /**
     * 判断是否是特殊用户
     * @param statisticsId
     * @return
     */
    @Override
    public String getSpecialUserById(Long statisticsId) {
        return userStatisticsInfoMapper.getSpecialUserById(statisticsId);
    }

    /**
     * 查询门店数据
     *
     * @param statisticsId 门店数据ID
     * @return 门店数据
     */
    @Override
    public UserStatisticsInfoDto selectUserStatisticsInfoById(Long statisticsId)
    {
        UserStatisticsInfoDto info = userStatisticsInfoMapper.selectUserStatisticsInfoById(statisticsId);
        if(null != info){
            //统计积分表
            StatisticsInfo statistics = statisticsInfoMapper.getStatisticsInfo(statisticsId.toString());
            if(StringUtils.isNotNull(statistics)){
                info.setSaleMonth(statistics.getSalesMonthValue());
                info.setActualSales(statistics.getActualSalesValue());
                info.setRefundAmount(statistics.getRefundAmountValue());
                info.setGoodsFrequency(statistics.getGoodsFrequencyValue());
                info.setLastGoods(statistics.getLastGoods());
            }
        }
        return info;
    }

    /**
     * 查询门店数据列表
     *
     * @param userStatisticsInfo 门店数据
     * @return 门店数据
     */
    @Override
    public List<UserStatisticsInfoDto> selectUserStatisticsInfoList(UserStatisticsInfo userStatisticsInfo)
    {
        List<UserStatisticsInfoDto> statisticsInfo = userStatisticsInfoMapper.getUserStatisticsInfo(userStatisticsInfo);

        if(null != statisticsInfo){
            statisticsInfo.stream().forEach(info->{
                //统计积分表
                StatisticsInfo statistics = statisticsInfoMapper.getStatisticsInfo(info.getStatisticsId());
                if(StringUtils.isNotNull(statistics)){
                    info.setSaleMonth(statistics.getSalesMonthValue());
                    info.setActualSales(statistics.getActualSalesValue());
                    info.setRefundAmount(statistics.getRefundAmountValue());
                    info.setGoodsFrequency(statistics.getGoodsFrequencyValue());
                    info.setLastGoods(statistics.getLastGoods());
                }
                if(StringUtils.isNotEmpty(info.getSpecialUser())){
                    if(info.getSpecialUser().equals(CommonUtils.NORMAL_USER)){
                        info.setSpecialUser("否");
                    }else{
                        info.setSpecialUser("是");
                    }
                }

            });
        }
        return statisticsInfo;
    }


    /**
     * 查询特殊用户
     * @param userStatisticsInfo
     * @return
     */
    @Override
    public List<UserStatisticsInfoDto> getSpecialUserInfo(UserStatisticsInfo userStatisticsInfo) {
        List<UserStatisticsInfoDto> specialUserInfo = userStatisticsInfoMapper.getSpecialUserInfo(userStatisticsInfo);
        if(null != specialUserInfo){
            specialUserInfo.stream().forEach(info->{
                //统计积分表
                StatisticsInfo statistics = statisticsInfoMapper.getStatisticsInfo(info.getStatisticsId());
                if(StringUtils.isNotNull(statistics)){
                    info.setSaleMonth(statistics.getSalesMonthValue());
                    info.setActualSales(statistics.getActualSalesValue());
                    info.setLastGoods(statistics.getLastGoods());
                }
            });
        }
        return specialUserInfo;
    }

    /**
     * 查询会员情况
     * @param userStatisticsInfo
     * @return
     */
    @Override
    public List<UserStatisticsInfoDto> getMemberUserInfo(UserStatisticsInfo userStatisticsInfo) {
        List<UserStatisticsInfoDto> memberUserInfo = userStatisticsInfoMapper.getMemberUserInfo(userStatisticsInfo);
        if(null != memberUserInfo){
            memberUserInfo.stream().forEach(info->{
                //统计积分表
                StatisticsInfo statistics = statisticsInfoMapper.getStatisticsInfo(info.getStatisticsId());
                if(StringUtils.isNotNull(statistics)){
                    info.setSaleMonth(statistics.getSalesMonthValue());
                    info.setActualSales(statistics.getActualSalesValue());
                    info.setLastGoods(statistics.getLastGoods());
                }
            });
        }
        return memberUserInfo;
    }

    /**
     * 根据ID查询特殊用户
     * @param statisticsId
     * @return
     */
    @Override
    public UserStatisticsInfoDto getSpecialUserByIdInfo(Long statisticsId) {
        UserStatisticsInfoDto info = userStatisticsInfoMapper.getSpecialUserByIdInfo(statisticsId);
        if(null != info){
            //统计积分表
            StatisticsInfo statistics = statisticsInfoMapper.getStatisticsInfo(statisticsId.toString());
            if(StringUtils.isNotNull(statistics)){
                info.setSaleMonth(statistics.getSalesMonthValue());
                info.setActualSales(statistics.getActualSalesValue());
                info.setLastGoods(statistics.getLastGoods());
            }
        }
        return info;
    }

    /**
     * 根据ID查询会员信息
     * @param statisticsId
     * @return
     */
    @Override
    public UserStatisticsInfoDto getMemberUserByIdInfo(Long statisticsId) {
        UserStatisticsInfoDto info = userStatisticsInfoMapper.getMemberUserByIdInfo(statisticsId);
        if(null != info){
            //统计积分表
            StatisticsInfo statistics = statisticsInfoMapper.getStatisticsInfo(statisticsId.toString());
            if(StringUtils.isNotNull(statistics)){
                info.setSaleMonth(statistics.getSalesMonthValue());
                info.setActualSales(statistics.getActualSalesValue());
                info.setLastGoods(statistics.getLastGoods());
            }
        }
        return info;
    }

    /**
     * 查询销售纪录管理
     * @param userStatisticsInfo
     * @return
     */
    @Override
    public List<UserStatisticsInfoDto> getSaleRecordInfo(UserStatisticsInfo userStatisticsInfo) {
        return userStatisticsInfoMapper.getSaleRecordInfo(userStatisticsInfo);
    }


    /**
     * 根据name查询Id
     * @param name
     * @return
     */
    @Override
    public UserStatisticsInfo getUserById(String name) {
        return userStatisticsInfoMapper.getUserById(UserInByIdParam.builder().name(name).startTime(TimeUtils.getYesterdayMinTime()).build());
    }

    /**
     * 根据name查询Id
     * @param name
     * @return
     */
    @Override
    public UserStatisticsInfo getUserByInfo(String name) {
        return userStatisticsInfoMapper.getUserById(UserInByIdParam.builder().name(name).build());
    }

    /**
     * 根据ID查询销售纪录
     * @param saleId
     * @return
     */
    @Override
    public UserStatisticsInfoDto getSaleRecordById(Long saleId) {
        return userStatisticsInfoMapper.getSaleRecordById(saleId);
    }

    /**
     * 定时计算积分
     * @return
     */
    @Override
    public List<UserStatisticsInfoDto> getTimingInfo(TimeInfoParam param) {
        return userStatisticsInfoMapper.getTimingInfo(param);
    }


    /**
     * 定时计算所有额度
     * @return
     */
    @Override
    public List<UserStatisticsInfoDto> getTimingSumInfo(TimeInfoParam param) {
        return userStatisticsInfoMapper.getTimingSumInfo(param);
    }

    /**
     * 查看积分计算等级
     * @param param
     * @return
     */
    @Override
    public UserIntegralCalculationDto getIntegralCalculation(TimeInfoParam param) {
        return userStatisticsInfoMapper.getIntegralCalculation(param);
    }

    /**
     * 新增门店数据
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
    @Override
    public int insertUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo)
    {
        userStatisticsInfo.setCreateTime(DateUtils.getNowDate());
        return userStatisticsInfoMapper.insertUserStatisticsInfo(userStatisticsInfo);
    }

    /**
     * 修改门店数据
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
    @Override
    @Transactional
    public int updateUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo)
    {
        if(StringUtils.isNotEmpty(userStatisticsInfo.getMember())){
            if("on".equals(userStatisticsInfo.getMember())){
                userStatisticsInfo.setMember("0");
            }else{
                userStatisticsInfo.setMember("1");
            }

        }
        UserStatisticsInfo info = UserStatisticsInfo.builder()
                .statisticsId(userStatisticsInfo.getStatisticsId())
                .phoneNumber(userStatisticsInfo.getPhoneNumber())
                .customerType(userStatisticsInfo.getCustomerType())
                .operator(StringUtils.isNotEmpty(userStatisticsInfo.getOperator())?userStatisticsInfo.getOperator():null)
                .member(StringUtils.isNotEmpty(userStatisticsInfo.getMember())?userStatisticsInfo.getMember():null)
                .build();
        info.setUpdateTime(DateUtils.getNowDate());
        return userStatisticsInfoMapper.updateUserStatisticsInfo(info);
    }

    /**
     * 修改等级
     * @param userStatisticsInfo
     * @return
     */
    @Override
    public int updateUserStatisticsGrade(UserStatisticsInfo userStatisticsInfo) {
        userStatisticsInfo.setUpdateTime(DateUtils.getNowDate());
        return userStatisticsInfoMapper.updateUserStatisticsGrade(userStatisticsInfo);
    }

    /**
     * 修改会员状态
     * @param userStatisticsInfo
     * @return
     */
    @Override
    public int updateUserStatisticsMember(UserStatisticsInfo userStatisticsInfo) {
        userStatisticsInfo.setUpdateTime(DateUtils.getNowDate());
        return userStatisticsInfoMapper.updateUserStatisticsMember(userStatisticsInfo);
    }

    /**
     * 用户降级
     * @param userStatisticsInfo
     * @return
     */
    @Override
    public int updateUserStatisticsSpecialUser(UserStatisticsInfo userStatisticsInfo) {
        return userStatisticsInfoMapper.updateUserStatisticsSpecialUser(userStatisticsInfo);
    }

    /**
     * 根据客户ID修改销售纪录
     *
     * @param userStatisticsInfo 销售纪录
     * @return 结果
     */
    @Override
    public int updateClerkSaleByCustomerId(UserStatisticsInfo userStatisticsInfo) {
        //修改销售数据
        ClerkSaleInfo saleInfo = ClerkSaleInfo.builder()
                .customerId(userStatisticsInfo.getStatisticsId())
                .modelNumber(StringUtils.isNotEmpty(userStatisticsInfo.getModelNumber())?userStatisticsInfo.getModelNumber():null)
                .productName(StringUtils.isNotEmpty(userStatisticsInfo.getProductName())?userStatisticsInfo.getProductName():null).build();
        saleInfo.setUpdateTime(DateUtils.getNowDate());
        return clerkSaleInfoMapper.updateClerkSaleByCustomerId(saleInfo);
    }

    /**
     * 升级特殊用户
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
    @Override
    public int updateSpecialUserInfo(UserStatisticsInfo userStatisticsInfo) {
        userStatisticsInfo.setUpdateTime(DateUtils.getNowDate());
        return userStatisticsInfoMapper.updateUserStatisticsInfo(userStatisticsInfo);
    }

    /**
     * 删除门店数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserStatisticsInfoByIds(String ids)
    {
        return userStatisticsInfoMapper.deleteUserStatisticsInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除门店数据信息
     *
     * @param statisticsId 门店数据ID
     * @return 结果
     */
    @Override
    public int deleteUserStatisticsInfoById(Long statisticsId)
    {
        return userStatisticsInfoMapper.deleteUserStatisticsInfoById(statisticsId);
    }

    /**
     * 导入用户数据
     *
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    @Override
    public String importUser(List<UserStatisticsInfo> userList, Boolean isUpdateSupport)
    {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        String branchInfo = branchInfoMapper.selectBranchInfoById(ShiroUtils.getUserId());
        if(StringUtils.isNull(branchInfo)){
            throw new BusinessException("该用户没有分店，请先增加分店！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (UserStatisticsInfo user : userList)
        {
            try
            {
                //查询该用户是否存在
                UserStatisticsInfoDto userStatisticsInfoDto = userStatisticsInfoMapper.getuserInfo(UserInByIdParam.builder().name(user.getName()).phoneNumber(user.getPhoneNumber()).build());
                if(StringUtils.isNotNull(userStatisticsInfoDto)){
                    isUpdateSupport = true;
                }
                if (isUpdateSupport)
                {
                    if(StringUtils.isNotEmpty(user.getOperatorTime())){
                        user.setOperatorTime("20"+user.getOperatorTime());
                    }
                    user.setUpdateBy(user.getOperator());
                    user.setUpdateTime(DateUtils.getNowDate());
                    userStatisticsInfoMapper.updateUserByName(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getName() + " 更新成功");
                }else if (StringUtils.isNotEmpty(user.getName()))
                {
                    if(StringUtils.isNotEmpty(user.getOperatorTime())){
                        user.setOperatorTime("20"+user.getOperatorTime());
                    }
                    this.insertUserStatisticsInfo(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getName() + " 导入成功");
                }

                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user.getName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }


    /**
     * 查询没有客户信息没有的用户
     * @return
     */
    @Override
    public List<NotClerkSaleInfo> getCustomerInfo(TimeInfoParam param) {
        return notClerkSaleInfoMapper.getCustomerInfo(param);
    }

    /**
     * 查询未注册人的销售纪录列表
     *
     * @param notClerkSaleInfo 未注册人的销售纪录
     * @return 未注册人的销售纪录集合
     */
    @Override
    public List<NotClerkSaleInfo> selectNotClerkSaleInfoList(NotClerkSaleInfo notClerkSaleInfo) {
        return notClerkSaleInfoMapper.selectNotClerkSaleInfoList(notClerkSaleInfo);
    }

}
