package com.ruoyi.project.system.client.service;

import com.ruoyi.project.system.client.domain.UserStatisticsInfo;

import java.util.List;

/**
 * 门店数据Service接口
 *
 * @author wer
 * @date 2021-04-16
 */
public interface IUserStatisticsInfoService
{
    /**
     * 查询门店数据
     *
     * @param statisticsId 门店数据ID
     * @return 门店数据
     */
    public UserStatisticsInfo selectUserStatisticsInfoById(Long statisticsId);

    /**
     * 查询门店数据列表
     *
     * @param userStatisticsInfo 门店数据
     * @return 门店数据集合
     */
    public List<UserStatisticsInfo> selectUserStatisticsInfoList(UserStatisticsInfo userStatisticsInfo);


    /**
     * 根据name查询Id
     * @param name
     * @return
     */
    UserStatisticsInfo getUserById(String name);
    /**
     * 新增门店数据
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
    public int insertUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 修改门店数据
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
    public int updateUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 批量删除门店数据
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserStatisticsInfoByIds(String ids);

    /**
     * 删除门店数据信息
     *
     * @param statisticsId 门店数据ID
     * @return 结果
     */
    public int deleteUserStatisticsInfoById(Long statisticsId);

    /**
     * 导入用户数据
     *
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importUser(List<UserStatisticsInfo> userList, Boolean isUpdateSupport);

}
