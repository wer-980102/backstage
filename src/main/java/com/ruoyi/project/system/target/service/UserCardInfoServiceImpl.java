package com.ruoyi.project.system.target.service;

import java.util.List;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.target.domain.UserCardInfo;
import com.ruoyi.project.system.target.mapper.UserCardInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 学习目标Service业务层处理
 *
 * @author wer
 * @date 2021-05-19
 */
@Service
public class UserCardInfoServiceImpl implements IUserCardInfoService
{
    @Autowired
    private UserCardInfoMapper userCardInfoMapper;

    /**
     * 查询学习目标
     *
     * @param cardId 学习目标ID
     * @return 学习目标
     */
    @Override
    public UserCardInfo selectUserCardInfoById(Long cardId)
    {
        return userCardInfoMapper.selectUserCardInfoById(cardId);
    }

    /**
     * 查询学习目标列表
     *
     * @param userCardInfo 学习目标
     * @return 学习目标
     */
    @Override
    public List<UserCardInfo> selectUserCardInfoList(UserCardInfo userCardInfo)
    {
        return userCardInfoMapper.selectUserCardInfoList(userCardInfo);
    }

    /**
     * 新增学习目标
     *
     * @param userCardInfo 学习目标
     * @return 结果
     */
    @Override
    public int insertUserCardInfo(UserCardInfo userCardInfo)
    {
        userCardInfo.setUserId(ShiroUtils.getUserId());
        userCardInfo.setCreateTime(DateUtils.getNowDate());
        return userCardInfoMapper.insertUserCardInfo(userCardInfo);
    }

    /**
     * 修改学习目标
     *
     * @param userCardInfo 学习目标
     * @return 结果
     */
    @Override
    public int updateUserCardInfo(UserCardInfo userCardInfo)
    {
        userCardInfo.setUpdateTime(DateUtils.getNowDate());
        return userCardInfoMapper.updateUserCardInfo(userCardInfo);
    }

    /**
     * 修改学习目标状态
     *
     * @param userCardInfo 学习目标
     * @return 结果
     */
    @Override
    public int updateUserCardStatus(UserCardInfo userCardInfo) {
        userCardInfo.setUpdateTime(DateUtils.getNowDate());
        userCardInfo.setUpdateBy(ShiroUtils.getLoginName());
        return userCardInfoMapper.updateUserCardStatus(userCardInfo);
    }

    /**
     * 动态删除学习目标
     * @param userCardInfo
     * @return
     */
    @Override
    public int updateUserStatus(UserCardInfo userCardInfo) {
        userCardInfo.setUpdateTime(DateUtils.getNowDate());
        userCardInfo.setUpdateBy(ShiroUtils.getLoginName());
        userCardInfo.setStatus(CommonUtils.NORMAL_STATUS);
        return userCardInfoMapper.updateUserStatus(userCardInfo);
    }

    /**
     * 删除学习目标对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserCardInfoByIds(String ids)
    {
        return userCardInfoMapper.deleteUserCardInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学习目标信息
     *
     * @param cardId 学习目标ID
     * @return 结果
     */
    @Override
    public int deleteUserCardInfoById(Long cardId)
    {
        return userCardInfoMapper.deleteUserCardInfoById(cardId);
    }
}
