package com.ruoyi.project.system.client.mapper;

import com.ruoyi.project.system.client.domain.UserStatisticsInfo;

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
     * 查询门店数据
     *
     * @param statisticsId 门店数据ID
     * @return 门店数据
     */
    public UserStatisticsInfo selectUserStatisticsInfoById(Long statisticsId);

    /**
     * 查询门店数据列表
     *
     * @param userStatisticsInfo 门店数据
     * @return 门店数据集合
     */
    public List<UserStatisticsInfo> selectUserStatisticsInfoList(UserStatisticsInfo userStatisticsInfo);

    /**
     * 新增门店数据
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
    public int insertUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo);

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
