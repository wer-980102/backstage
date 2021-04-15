package com.ruoyi.project.system.statistics.service;

import com.ruoyi.project.system.statistics.domain.UserInfo;

import java.util.List;

/**
 * 用户 业务层
 * 
 * @author ruoyi
 */
public interface IStatisticsService
{
    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<UserInfo> selectUserList(UserInfo user);


    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteUserByIds(Long ids);


    /**
     * 导入用户数据
     * 
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importUser(List<UserInfo> userList, Boolean isUpdateSupport);

}
