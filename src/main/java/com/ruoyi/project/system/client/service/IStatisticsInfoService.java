package com.ruoyi.project.system.client.service;

import com.ruoyi.project.system.client.domain.StatisticsInfo;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author wer
 * @date 2021-04-23
 */
public interface IStatisticsInfoService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param statisticsId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public StatisticsInfo selectStatisticsInfoById(Long statisticsId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param statisticsInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<StatisticsInfo> selectStatisticsInfoList(StatisticsInfo statisticsInfo);

    /**
     * 新增【请填写功能名称】
     *
     * @param statisticsInfo 【请填写功能名称】
     * @return 结果
     */
     int insertStatisticsInfo(StatisticsInfo statisticsInfo);

    /**
     * 修改【请填写功能名称】
     *
     * @param statisticsInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateStatisticsInfo(StatisticsInfo statisticsInfo);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStatisticsInfoByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param statisticsId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteStatisticsInfoById(Long statisticsId);
}
