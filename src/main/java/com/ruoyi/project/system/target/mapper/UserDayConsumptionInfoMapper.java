package com.ruoyi.project.system.target.mapper;

import com.ruoyi.project.system.client.domain.param.TimeInfoParam;
import com.ruoyi.project.system.target.domain.UserDayConsumptionInfo;
import com.ruoyi.project.system.target.domain.dto.TimingCalculationDto;

import java.util.List;

/**
 * 每日消费流水Mapper接口
 *
 * @author wer
 * @date 2021-05-19
 */
public interface UserDayConsumptionInfoMapper
{
    /**
     * 查询每日消费流水
     *
     * @param dayConsumptionId 每日消费流水ID
     * @return 每日消费流水
     */
    public UserDayConsumptionInfo selectUserDayConsumptionInfoById(Long dayConsumptionId);

    /**
     * 定时计算消费金额
     * @param param
     * @return
     */
    TimingCalculationDto TimeCalculation(TimeInfoParam param);

    /**
     * 查询每日消费流水列表
     *
     * @param userDayConsumptionInfo 每日消费流水
     * @return 每日消费流水集合
     */
     List<UserDayConsumptionInfo> selectUserDayConsumptionInfoList(UserDayConsumptionInfo userDayConsumptionInfo);

    /**
     * 新增每日消费流水
     *
     * @param userDayConsumptionInfo 每日消费流水
     * @return 结果
     */
    public int insertUserDayConsumptionInfo(UserDayConsumptionInfo userDayConsumptionInfo);

    /**
     * 修改每日消费流水
     *
     * @param userDayConsumptionInfo 每日消费流水
     * @return 结果
     */
    public int updateUserDayConsumptionInfo(UserDayConsumptionInfo userDayConsumptionInfo);

    /**
     * 修改预期状态
     * @param userDayConsumptionInfo
     * @return
     */
    int updateUserDayConsumptionStatus(UserDayConsumptionInfo userDayConsumptionInfo);

    /**
     * 动态删除状态
     * @param userDayConsumptionInfo
     * @return
     */
    int updateUserDayStatus(UserDayConsumptionInfo userDayConsumptionInfo);

    /**
     * 删除每日消费流水
     *
     * @param dayConsumptionId 每日消费流水ID
     * @return 结果
     */
    public int deleteUserDayConsumptionInfoById(Long dayConsumptionId);

    /**
     * 批量删除每日消费流水
     *
     * @param dayConsumptionIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserDayConsumptionInfoByIds(String[] dayConsumptionIds);
}
