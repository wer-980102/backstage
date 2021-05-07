package com.ruoyi.project.system.client.mapper;

import com.ruoyi.project.system.client.domain.StatisticsInfo;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author wer
 * @date 2021-04-23
 */
public interface StatisticsInfoMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param customerId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
     StatisticsInfo selectStatisticsInfoById(Long customerId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param statisticsInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
     List<StatisticsInfo> selectStatisticsInfoList(StatisticsInfo statisticsInfo);

    /**
     * 查询存不存在这个客户
     * @param customerId
     * @return
     */
    StatisticsInfo getUserStatisticsInfo(String customerId);
    /**
     *  查询统计值与客户信息管理统计进行匹配
     * @param customerId
     * @return
     */
    StatisticsInfo getStatisticsInfo(String customerId);

    /**
     * 新增【请填写功能名称】
     *
     * @param statisticsInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertStatisticsInfo(StatisticsInfo statisticsInfo);

    /**
     * 修改【请填写功能名称】
     *
     * @param statisticsInfo 【请填写功能名称】
     * @return 结果
     */
     int updateStatisticsInfo(StatisticsInfo statisticsInfo);

    /**
     * 删除【请填写功能名称】
     *
     * @param statisticsId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteStatisticsInfoById(Long statisticsId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param statisticsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteStatisticsInfoByIds(String[] statisticsIds);
}
