package com.ruoyi.project.system.client.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.client.domain.UserIntegralInfo;
import com.ruoyi.project.system.client.domain.param.TimeInfoParam;
import com.ruoyi.project.system.client.mapper.UserIntegralInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.text.Convert;

/**
 * 积分规则Service业务层处理
 *
 * @author wer
 * @date 2021-04-22
 */
@Service
public class UserIntegralInfoServiceImpl implements IUserIntegralInfoService
{
    @Autowired
    private UserIntegralInfoMapper userIntegralInfoMapper;

    /**
     * 查询积分规则
     *
     * @param integralId 积分规则ID
     * @return 积分规则
     */
    @Override
    public UserIntegralInfo selectUserIntegralInfoById(Long integralId)
    {
        return userIntegralInfoMapper.selectUserIntegralInfoById(integralId);
    }


    /**
     * 查询积分规则列表
     *
     * @param userIntegralInfo 积分规则
     * @return 积分规则
     */
    @Override
    public List<UserIntegralInfo> selectUserIntegralInfoList(UserIntegralInfo userIntegralInfo)
    {
        return userIntegralInfoMapper.selectUserIntegralInfoList(userIntegralInfo);
    }

    /**
     * 新增积分规则
     *
     * @param userIntegralInfo 积分规则
     * @return 结果
     */
    @Override
    public int insertUserIntegralInfo(UserIntegralInfo userIntegralInfo)
    {
        userIntegralInfo.setCreateTime(DateUtils.getNowDate());
        return userIntegralInfoMapper.insertUserIntegralInfo(userIntegralInfo);
    }

    /**
     * 修改积分规则
     *
     * @param userIntegralInfo 积分规则
     * @return 结果
     */
    @Override
    public int updateUserIntegralInfo(UserIntegralInfo userIntegralInfo)
    {
        userIntegralInfo.setUpdateTime(DateUtils.getNowDate());
        return userIntegralInfoMapper.updateUserIntegralInfo(userIntegralInfo);
    }

    /**
     * 删除积分规则对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserIntegralInfoByIds(String ids)
    {
        return userIntegralInfoMapper.deleteUserIntegralInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除积分规则信息
     *
     * @param integralId 积分规则ID
     * @return 结果
     */
    @Override
    public int deleteUserIntegralInfoById(Long integralId)
    {
        return userIntegralInfoMapper.deleteUserIntegralInfoById(integralId);
    }
}
