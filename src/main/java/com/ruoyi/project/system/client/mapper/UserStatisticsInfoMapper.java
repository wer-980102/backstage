package com.ruoyi.project.system.client.mapper;

import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.UserIntegralCalculationDto;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.domain.param.TimeInfoParam;
import com.ruoyi.project.system.client.domain.param.UserInByIdParam;

import java.util.List;

/**
 * 门店数据Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-16
 */
public interface UserStatisticsInfoMapper
{
    /**
     * 判断是否是特殊用户
     * @param statisticsId
     * @return
     */
    String getSpecialUserById(Long statisticsId);
    /**
     * 查询门店数据
     *
     * @param statisticsId 门店数据ID
     * @return 门店数据
     */
     UserStatisticsInfoDto selectUserStatisticsInfoById(Long statisticsId);

    /**
     * 查询所有数据
     * @param userStatisticsInfo
     * @return
     */
    List<UserStatisticsInfoDto> getUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 根据name查询Id
     * @param param
     * @return
     */
    UserStatisticsInfo getUserById(UserInByIdParam param);

    /**
     * 查询该用户是否存在
     * @param param
     * @return
     */
    UserStatisticsInfoDto getuserInfo(UserInByIdParam param);
    /**
     * 查询门店数据列表
     *
     * @param userStatisticsInfo 门店数据
     * @return 门店数据集合
     */
    public List<UserStatisticsInfo> selectUserStatisticsInfoList(UserStatisticsInfo userStatisticsInfo);

    /**
     * 查询特殊客户管理
     * @param userStatisticsInfo
     * @return
     */
    List<UserStatisticsInfoDto> getSpecialUserInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 查询会员情况
     * @param userStatisticsInfo
     * @return
     */
    List<UserStatisticsInfoDto> getMemberUserInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 根据ID查询特殊用户
     * @param statisticsId
     * @return
     */
    UserStatisticsInfoDto getSpecialUserByIdInfo(Long statisticsId);

    /**
     * 根据ID查询会员信息
     * @param statisticsId
     * @return
     */
    UserStatisticsInfoDto getMemberUserByIdInfo(Long statisticsId);
    /**
     * 查询销售纪录管理
     * @param userStatisticsInfo
     * @return
     */
    List<UserStatisticsInfoDto> getSaleRecordInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 根据ID查询销售纪录
     * @param statisticsId
     * @return
     */
    UserStatisticsInfoDto getSaleRecordById(Long statisticsId);

    /**
     * 定时计算积分
     * @return
     */
    List<UserStatisticsInfoDto> getTimingInfo(TimeInfoParam param);

    /**
     * 定时计算所有额度
     * @return
     */
    List<UserStatisticsInfoDto> getTimingSumInfo(TimeInfoParam param);

    /**
     * 查看积分计算等级
     * @param param
     * @return
     */
    UserIntegralCalculationDto getIntegralCalculation(TimeInfoParam param);
    /**
     * 新增门店数据
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
     int insertUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 一键减分
     * @return
     */
    List<String> getScoreReduction();

    /**
     * 修改门店数据
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
     int updateUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 重复用户进行修改
     * @param userStatisticsInfo
     * @return
     */
     int updateUserByName(UserStatisticsInfo userStatisticsInfo);

    /**
     * 修改等级
     * @param userStatisticsInfo
     * @return
     */
     int updateUserStatisticsGrade(UserStatisticsInfo userStatisticsInfo);

    /**
     * 修改会员状态
     * @param userStatisticsInfo
     * @return
     */
     int updateUserStatisticsMember(UserStatisticsInfo userStatisticsInfo);

    /**
     * 用户降级
     * @param userStatisticsInfo
     * @return
     */
     int updateUserStatisticsSpecialUser(UserStatisticsInfo userStatisticsInfo);
    /**
     * 删除门店数据
     *
     * @param statisticsId 门店数据ID
     * @return 结果
     */
    public int deleteUserStatisticsInfoById(Long statisticsId);

    /**
     * 批量删除门店数据
     *
     * @param statisticsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserStatisticsInfoByIds(String[] statisticsIds);
}
