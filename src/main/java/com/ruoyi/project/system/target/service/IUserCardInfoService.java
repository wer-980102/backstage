package com.ruoyi.project.system.target.service;

import com.ruoyi.project.system.target.domain.UserCardInfo;

import java.util.List;

/**
 * 学习目标Service接口
 *
 * @author wer
 * @date 2021-05-19
 */
public interface IUserCardInfoService
{
    /**
     * 查询学习目标
     *
     * @param cardId 学习目标ID
     * @return 学习目标
     */
    public UserCardInfo selectUserCardInfoById(Long cardId);

    /**
     * 查询学习目标列表
     *
     * @param userCardInfo 学习目标
     * @return 学习目标集合
     */
    public List<UserCardInfo> selectUserCardInfoList(UserCardInfo userCardInfo);

    /**
     * 新增学习目标
     *
     * @param userCardInfo 学习目标
     * @return 结果
     */
    public int insertUserCardInfo(UserCardInfo userCardInfo);

    /**
     * 修改学习目标
     *
     * @param userCardInfo 学习目标
     * @return 结果
     */
    public int updateUserCardInfo(UserCardInfo userCardInfo);

    /**
     * 批量删除学习目标
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserCardInfoByIds(String ids);

    /**
     * 删除学习目标信息
     *
     * @param cardId 学习目标ID
     * @return 结果
     */
    public int deleteUserCardInfoById(Long cardId);
}
