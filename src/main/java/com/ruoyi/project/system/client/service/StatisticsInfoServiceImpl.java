package com.ruoyi.project.system.client.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.client.domain.StatisticsInfo;
import com.ruoyi.project.system.client.mapper.StatisticsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author wer
 * @date 2021-04-23
 */
@Service
public class StatisticsInfoServiceImpl implements IStatisticsInfoService
{
    @Autowired
    private StatisticsInfoMapper statisticsInfoMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param customerId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public StatisticsInfo selectStatisticsInfoById(Long customerId)
    {
        return statisticsInfoMapper.selectStatisticsInfoById(customerId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param statisticsInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<StatisticsInfo> selectStatisticsInfoList(StatisticsInfo statisticsInfo)
    {
        return statisticsInfoMapper.selectStatisticsInfoList(statisticsInfo);
    }

    /**
     * 查询存不存在这个客户
     * @param customerId
     * @return
     */
    @Override
    public StatisticsInfo getUserStatisticsInfo(String customerId) {
        return statisticsInfoMapper.getUserStatisticsInfo(customerId);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param statisticsInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertStatisticsInfo(StatisticsInfo statisticsInfo)
    {
        statisticsInfo.setCreateTime(DateUtils.getNowDate());
        return statisticsInfoMapper.insertStatisticsInfo(statisticsInfo);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param statisticsInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateStatisticsInfo(StatisticsInfo statisticsInfo)
    {
        statisticsInfo.setUpdateTime(DateUtils.getNowDate());
        return statisticsInfoMapper.updateStatisticsInfo(statisticsInfo);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStatisticsInfoByIds(String ids)
    {
        return statisticsInfoMapper.deleteStatisticsInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param statisticsId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteStatisticsInfoById(Long statisticsId)
    {
        return statisticsInfoMapper.deleteStatisticsInfoById(statisticsId);
    }
}
