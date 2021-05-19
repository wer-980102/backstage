package com.ruoyi.project.system.target.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.target.domain.UserDayConsumptionInfo;
import com.ruoyi.project.system.target.mapper.UserDayConsumptionInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 每日消费流水Service业务层处理
 *
 * @author wer
 * @date 2021-05-19
 */
@Service
public class UserDayConsumptionInfoServiceImpl implements IUserDayConsumptionInfoService
{
    @Autowired
    private UserDayConsumptionInfoMapper userDayConsumptionInfoMapper;

    /**
     * 查询每日消费流水
     *
     * @param dayConsumptionId 每日消费流水ID
     * @return 每日消费流水
     */
    @Override
    public UserDayConsumptionInfo selectUserDayConsumptionInfoById(Long dayConsumptionId)
    {
        return userDayConsumptionInfoMapper.selectUserDayConsumptionInfoById(dayConsumptionId);
    }

    /**
     * 查询每日消费流水列表
     *
     * @param userDayConsumptionInfo 每日消费流水
     * @return 每日消费流水
     */
    @Override
    public List<UserDayConsumptionInfo> selectUserDayConsumptionInfoList(UserDayConsumptionInfo userDayConsumptionInfo)
    {
        return userDayConsumptionInfoMapper.selectUserDayConsumptionInfoList(userDayConsumptionInfo);
    }

    /**
     * 新增每日消费流水
     *
     * @param userDayConsumptionInfo 每日消费流水
     * @return 结果
     */
    @Override
    public int insertUserDayConsumptionInfo(UserDayConsumptionInfo userDayConsumptionInfo)
    {
        userDayConsumptionInfo.setCreateTime(DateUtils.getNowDate());
        return userDayConsumptionInfoMapper.insertUserDayConsumptionInfo(userDayConsumptionInfo);
    }

    /**
     * 修改每日消费流水
     *
     * @param userDayConsumptionInfo 每日消费流水
     * @return 结果
     */
    @Override
    public int updateUserDayConsumptionInfo(UserDayConsumptionInfo userDayConsumptionInfo)
    {
        userDayConsumptionInfo.setUpdateTime(DateUtils.getNowDate());
        return userDayConsumptionInfoMapper.updateUserDayConsumptionInfo(userDayConsumptionInfo);
    }

    /**
     * 删除每日消费流水对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserDayConsumptionInfoByIds(String ids)
    {
        return userDayConsumptionInfoMapper.deleteUserDayConsumptionInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除每日消费流水信息
     *
     * @param dayConsumptionId 每日消费流水ID
     * @return 结果
     */
    @Override
    public int deleteUserDayConsumptionInfoById(Long dayConsumptionId)
    {
        return userDayConsumptionInfoMapper.deleteUserDayConsumptionInfoById(dayConsumptionId);
    }
}
