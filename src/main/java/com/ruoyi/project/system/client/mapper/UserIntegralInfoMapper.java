package com.ruoyi.project.system.client.mapper;

import com.ruoyi.project.system.client.domain.UserIntegralInfo;
import com.ruoyi.project.system.client.domain.param.TimeInfoParam;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * 积分规则Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-22
 */
public interface UserIntegralInfoMapper
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
    public int insertUserIntegralInfo(UserIntegralInfo userIntegralInfo);

    /**
     * 修改积分规则
     *
     * @param userIntegralInfo 积分规则
     * @return 结果
     */
     int updateUserIntegralInfo(UserIntegralInfo userIntegralInfo);

    /**
     * 用户一键减分
     * @return
     */
     int updateUserIntegral(UserIntegralInfo userIntegralInfo);

    /**
     * 删除积分规则
     *
     * @param integralId 积分规则ID
     * @return 结果
     */
     int deleteUserIntegralInfoById(Long integralId);

    /**
     * 批量删除积分规则
     *
     * @param integralIds 需要删除的数据ID
     * @return 结果
     */
     int deleteUserIntegralInfoByIds(String[] integralIds);
}
