package com.ruoyi.project.system.target.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.target.domain.UserMonthConsumptionInfo;
import com.ruoyi.project.system.target.mapper.UserMonthConsumptionInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 每月消费流水Service业务层处理
 *
 * @author wer
 * @date 2021-05-19
 */
@Service
public class UserMonthConsumptionInfoServiceImpl implements IUserMonthConsumptionInfoService
{
    @Autowired
    private UserMonthConsumptionInfoMapper userMonthConsumptionInfoMapper;

    /**
     * 查询每月消费流水
     *
     * @param monthConsumptionId 每月消费流水ID
     * @return 每月消费流水
     */
    @Override
    public UserMonthConsumptionInfo selectUserMonthConsumptionInfoById(Long monthConsumptionId)
    {
        return userMonthConsumptionInfoMapper.selectUserMonthConsumptionInfoById(monthConsumptionId);
    }

    /**
     * 查询每月消费流水列表
     *
     * @param userMonthConsumptionInfo 每月消费流水
     * @return 每月消费流水
     */
    @Override
    public List<UserMonthConsumptionInfo> selectUserMonthConsumptionInfoList(UserMonthConsumptionInfo userMonthConsumptionInfo)
    {
        return userMonthConsumptionInfoMapper.selectUserMonthConsumptionInfoList(userMonthConsumptionInfo);
    }

    /**
     * 新增每月消费流水
     *
     * @param userMonthConsumptionInfo 每月消费流水
     * @return 结果
     */
    @Override
    public int insertUserMonthConsumptionInfo(UserMonthConsumptionInfo userMonthConsumptionInfo)
    {
        userMonthConsumptionInfo.setCreateTime(DateUtils.getNowDate());
        return userMonthConsumptionInfoMapper.insertUserMonthConsumptionInfo(userMonthConsumptionInfo);
    }

    /**
     * 修改每月消费流水
     *
     * @param userMonthConsumptionInfo 每月消费流水
     * @return 结果
     */
    @Override
    public int updateUserMonthConsumptionInfo(UserMonthConsumptionInfo userMonthConsumptionInfo)
    {
        userMonthConsumptionInfo.setUpdateTime(DateUtils.getNowDate());
        return userMonthConsumptionInfoMapper.updateUserMonthConsumptionInfo(userMonthConsumptionInfo);
    }

    /**
     * 删除每月消费流水对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserMonthConsumptionInfoByIds(String ids)
    {
        return userMonthConsumptionInfoMapper.deleteUserMonthConsumptionInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除每月消费流水信息
     *
     * @param monthConsumptionId 每月消费流水ID
     * @return 结果
     */
    @Override
    public int deleteUserMonthConsumptionInfoById(Long monthConsumptionId)
    {
        return userMonthConsumptionInfoMapper.deleteUserMonthConsumptionInfoById(monthConsumptionId);
    }
}