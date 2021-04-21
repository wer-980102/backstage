package com.ruoyi.project.system.client.mapper;

import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.UserMonthInfoDto;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;

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
     * @param name
     * @return
     */
    UserStatisticsInfo getUserById(String name);
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
     * 根据ID查询特殊用户
     * @param statisticsId
     * @return
     */
    UserStatisticsInfoDto getSpecialUserByIdInfo(Long statisticsId);
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
     * 新增门店数据
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
     int insertUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 修改门店数据
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
    public int updateUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo);

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