package com.ruoyi.project.system.target.mapper;

import com.ruoyi.project.system.target.domain.UserMotionInfo;

import java.util.List;

/**
 * 运动信息Mapper接口
 *
 * @author wer
 * @date 2021-05-19
 */
public interface UserMotionInfoMapper
{
    /**
     * 查询运动信息
     *
     * @param motionId 运动信息ID
     * @return 运动信息
     */
    public UserMotionInfo selectUserMotionInfoById(Long motionId);

    /**
     * 查询运动信息列表
     *
     * @param userMotionInfo 运动信息
     * @return 运动信息集合
     */
     List<UserMotionInfo> selectUserMotionInfoList(UserMotionInfo userMotionInfo);

    /**
     * 新增运动信息
     *
     * @param userMotionInfo 运动信息
     * @return 结果
     */
    public int insertUserMotionInfo(UserMotionInfo userMotionInfo);

    /**
     * 修改运动信息
     *
     * @param userMotionInfo 运动信息
     * @return 结果
     */
    public int updateUserMotionInfo(UserMotionInfo userMotionInfo);

    /**
     * 修改状态
     * @param userMotionInfo
     * @return
     */
    int updateUserMotionStandardStatus(UserMotionInfo userMotionInfo);

    /**
     * 动态删除
     * @param userMotionInfo
     * @return
     */
    int updateUserStatus(UserMotionInfo userMotionInfo);

    /**
     * 删除运动信息
     *
     * @param motionId 运动信息ID
     * @return 结果
     */
    public int deleteUserMotionInfoById(Long motionId);

    /**
     * 批量删除运动信息
     *
     * @param motionIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserMotionInfoByIds(String[] motionIds);
}
