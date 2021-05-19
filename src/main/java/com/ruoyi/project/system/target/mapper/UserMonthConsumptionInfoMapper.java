package com.ruoyi.project.system.target.mapper;

import com.ruoyi.project.system.target.domain.UserMonthConsumptionInfo;

import java.util.List;

/**
 * 每月消费流水Mapper接口
 *
 * @author wer
 * @date 2021-05-19
 */
public interface UserMonthConsumptionInfoMapper
{
    /**
     * 查询每月消费流水
     *
     * @param monthConsumptionId 每月消费流水ID
     * @return 每月消费流水
     */
    public UserMonthConsumptionInfo selectUserMonthConsumptionInfoById(Long monthConsumptionId);

    /**
     * 查询每月消费流水列表
     *
     * @param userMonthConsumptionInfo 每月消费流水
     * @return 每月消费流水集合
     */
    public List<UserMonthConsumptionInfo> selectUserMonthConsumptionInfoList(UserMonthConsumptionInfo userMonthConsumptionInfo);

    /**
     * 新增每月消费流水
     *
     * @param userMonthConsumptionInfo 每月消费流水
     * @return 结果
     */
    public int insertUserMonthConsumptionInfo(UserMonthConsumptionInfo userMonthConsumptionInfo);

    /**
     * 修改每月消费流水
     *
     * @param userMonthConsumptionInfo 每月消费流水
     * @return 结果
     */
    public int updateUserMonthConsumptionInfo(UserMonthConsumptionInfo userMonthConsumptionInfo);

    /**
     * 删除每月消费流水
     *
     * @param monthConsumptionId 每月消费流水ID
     * @return 结果
     */
    public int deleteUserMonthConsumptionInfoById(Long monthConsumptionId);

    /**
     * 批量删除每月消费流水
     *
     * @param monthConsumptionIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserMonthConsumptionInfoByIds(String[] monthConsumptionIds);
}
