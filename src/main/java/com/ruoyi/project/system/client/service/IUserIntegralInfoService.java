package com.ruoyi.project.system.client.service;

import com.ruoyi.project.system.client.domain.UserIntegralInfo;
import com.ruoyi.project.system.client.domain.param.TimeInfoParam;

import java.util.List;

/**
 * 积分规则Service接口
 *
 * @author wer
 * @date 2021-04-22
 */
public interface IUserIntegralInfoService
{
    /**
     * 查询积分规则
     *
     * @param integralId 积分规则ID
     * @return 积分规则
     */
     UserIntegralInfo selectUserIntegralInfoById(Long integralId);

    /**
     * 查询积分规则列表
     *
     * @param userIntegralInfo 积分规则
     * @return 积分规则集合
     */
     List<UserIntegralInfo> selectUserIntegralInfoList(UserIntegralInfo userIntegralInfo);

    /**
     * 新增积分规则
     *
     * @param userIntegralInfo 积分规则
     * @return 结果
     */
     int insertUserIntegralInfo(UserIntegralInfo userIntegralInfo);

    /**
     * 修改积分规则
     *
     * @param userIntegralInfo 积分规则
     * @return 结果
     */
     int updateUserIntegralInfo(UserIntegralInfo userIntegralInfo);

    /**
     * 批量删除积分规则
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteUserIntegralInfoByIds(String ids);

    /**
     * 删除积分规则信息
     *
     * @param integralId 积分规则ID
     * @return 结果
     */
     int deleteUserIntegralInfoById(Long integralId);
}
