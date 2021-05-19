package com.ruoyi.project.system.target.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.target.domain.UserMotionInfo;
import com.ruoyi.project.system.target.mapper.UserMotionInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 运动信息Service业务层处理
 *
 * @author wer
 * @date 2021-05-19
 */
@Service
public class UserMotionInfoServiceImpl implements IUserMotionInfoService
{
    @Autowired
    private UserMotionInfoMapper userMotionInfoMapper;

    /**
     * 查询运动信息
     *
     * @param motionId 运动信息ID
     * @return 运动信息
     */
    @Override
    public UserMotionInfo selectUserMotionInfoById(Long motionId)
    {
        return userMotionInfoMapper.selectUserMotionInfoById(motionId);
    }

    /**
     * 查询运动信息列表
     *
     * @param userMotionInfo 运动信息
     * @return 运动信息
     */
    @Override
    public List<UserMotionInfo> selectUserMotionInfoList(UserMotionInfo userMotionInfo)
    {
        return userMotionInfoMapper.selectUserMotionInfoList(userMotionInfo);
    }

    /**
     * 新增运动信息
     *
     * @param userMotionInfo 运动信息
     * @return 结果
     */
    @Override
    public int insertUserMotionInfo(UserMotionInfo userMotionInfo)
    {
        userMotionInfo.setCreateTime(DateUtils.getNowDate());
        return userMotionInfoMapper.insertUserMotionInfo(userMotionInfo);
    }

    /**
     * 修改运动信息
     *
     * @param userMotionInfo 运动信息
     * @return 结果
     */
    @Override
    public int updateUserMotionInfo(UserMotionInfo userMotionInfo)
    {
        userMotionInfo.setUpdateTime(DateUtils.getNowDate());
        return userMotionInfoMapper.updateUserMotionInfo(userMotionInfo);
    }

    /**
     * 删除运动信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserMotionInfoByIds(String ids)
    {
        return userMotionInfoMapper.deleteUserMotionInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除运动信息信息
     *
     * @param motionId 运动信息ID
     * @return 结果
     */
    @Override
    public int deleteUserMotionInfoById(Long motionId)
    {
        return userMotionInfoMapper.deleteUserMotionInfoById(motionId);
    }
}
