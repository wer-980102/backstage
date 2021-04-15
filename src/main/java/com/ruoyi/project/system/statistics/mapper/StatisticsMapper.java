package com.ruoyi.project.system.statistics.mapper;

import com.ruoyi.project.system.statistics.domain.UserInfo;

import java.util.List;

/**
 * 用户表 数据层
 * 
 * @author ruoyi
 */
public interface StatisticsMapper
{
    /**
     * 根据条件分页查询用户列表
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<UserInfo> selectUserList(UserInfo user);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public UserInfo selectUserByLoginName(String userName);


    /**
     * 通过用户ID删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserById(Long userId);

    /**
     * 修改用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(UserInfo user);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(UserInfo user);

}
