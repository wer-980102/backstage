package com.ruoyi.project.system.client.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.client.domain.ClerkSaleInfo;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.UserMonthInfoDto;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.mapper.ClerkSaleInfoMapper;
import com.ruoyi.project.system.client.mapper.UserStatisticsInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 门店数据Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-16
 */
@Service
public class UserStatisticsInfoServiceImpl implements IUserStatisticsInfoService
{

    private static final Logger log = LoggerFactory.getLogger(UserStatisticsInfoServiceImpl.class);
    @Autowired
    private UserStatisticsInfoMapper userStatisticsInfoMapper;

    @Autowired
    private ClerkSaleInfoMapper clerkSaleInfoMapper;
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
            if(StringUtils.isNotNull(info.getActualSales())){
                if(info.getActualSales()>=10000){
                    info.setMemberType("一级");
                }else if(info.getActualSales()>=8000 && info.getActualSales()<=9999){
                    info.setMemberType("二级");
                }else if(info.getActualSales()>=5000 && info.getActualSales()<=7999){
                    info.setMemberType("三级");
                }else{
                    info.setMemberType("四级");
                }
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
                if(StringUtils.isNotEmpty(info.getSpecialUser())){
                    if(info.getSpecialUser().equals(CommonUtils.NORMAL_USER)){
                        info.setSpecialUser("否");
                    }else{
                        info.setSpecialUser("是");
                    }
                }

                if(info.getActualSales()>=10000){
                    info.setMemberType("一级");
                }else if(info.getActualSales()>=8000 && info.getActualSales()<=9999){
                    info.setMemberType("二级");
                }else if(info.getActualSales()>=5000 && info.getActualSales()<=7999){
                    info.setMemberType("三级");
                }else{
                    info.setMemberType("四级");
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
        return userStatisticsInfoMapper.getSpecialUserInfo(userStatisticsInfo);
    }

    /**
     * 根据ID查询特殊用户
     * @param statisticsId
     * @return
     */
    @Override
    public UserStatisticsInfoDto getSpecialUserByIdInfo(Long statisticsId) {
        return userStatisticsInfoMapper.getSpecialUserByIdInfo(statisticsId);
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
        return userStatisticsInfoMapper.getUserById(name);
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
    public List<UserStatisticsInfoDto> getTimingInfo() {
        return userStatisticsInfoMapper.getTimingInfo();
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
        //修改销售数据
        ClerkSaleInfo saleInfo = ClerkSaleInfo.builder()
                .saleId(userStatisticsInfo.getSaleId())
                .modelNumber(StringUtils.isNotEmpty(userStatisticsInfo.getModelNumber())?userStatisticsInfo.getModelNumber():null)
                .productName(StringUtils.isNotEmpty(userStatisticsInfo.getProductName())?userStatisticsInfo.getProductName():null).build();
        saleInfo.setUpdateTime(DateUtils.getNowDate());
        return clerkSaleInfoMapper.updateClerkSaleInfo(saleInfo);
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
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (UserStatisticsInfo user : userList)
        {
            try
            {
                if (StringUtils.isNotEmpty(user.getName()))
                {
                    if(StringUtils.isNotEmpty(user.getOperatorTime())){
                        user.setOperatorTime("20"+user.getOperatorTime());
                    }
                    this.insertUserStatisticsInfo(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    if(StringUtils.isNotEmpty(user.getOperatorTime())){
                        user.setOperatorTime("20"+user.getOperatorTime());
                    }
                    user.setUpdateBy(user.getOperator());
                    this.updateUserStatisticsInfo(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getName() + " 更新成功");
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
}
