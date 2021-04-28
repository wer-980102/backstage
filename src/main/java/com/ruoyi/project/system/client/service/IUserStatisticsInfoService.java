package com.ruoyi.project.system.client.service;

import com.ruoyi.project.system.client.domain.ClerkSaleInfo;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.domain.param.TimeInfoParam;

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
     * 判断是否是特殊用户
     * @param statisticsId
     * @return
     */
    String getSpecialUserById(Long statisticsId);
    /**
     * 查询门店数据
     *
     * @param statisticsId 门店数据ID
     * @return 门店数据
     */
     UserStatisticsInfoDto selectUserStatisticsInfoById(Long statisticsId);

    /**
     * 查询门店数据列表
     *
     * @param userStatisticsInfo 门店数据
     * @return 门店数据集合
     */
     List<UserStatisticsInfoDto> selectUserStatisticsInfoList(UserStatisticsInfo userStatisticsInfo);

    /**
     * 查询特殊用户
     * @param userStatisticsInfo
     * @return
     */
    List<UserStatisticsInfoDto> getSpecialUserInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 根据ID查询特殊用户
     * @param statisticsId
     * @return
     */
    UserStatisticsInfoDto getSpecialUserByIdInfo(Long statisticsId);
    /**
     * 查询销售纪录管理
     * @param userStatisticsInfo
     * @return
     */
    List<UserStatisticsInfoDto> getSaleRecordInfo(UserStatisticsInfo userStatisticsInfo);
    /**
     * 根据name查询Id
     * @param name
     * @return
     */
    UserStatisticsInfo getUserById(String name);


    /**
     * 根据ID查询销售纪录
     * @param saleId
     * @return
     */
    UserStatisticsInfoDto getSaleRecordById(Long saleId);

    /**
     * 定时计算积分
     * @return
     */
    List<UserStatisticsInfoDto> getTimingInfo(TimeInfoParam param);

    /**
     * 定时计算所有额度
     * @return
     */
    List<UserStatisticsInfoDto> getTimingSumInfo(TimeInfoParam param);
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
     int updateUserStatisticsInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 根据客户ID修改销售纪录
     *
     * @param userStatisticsInfo 销售纪录
     * @return 结果
     */
    int updateClerkSaleByCustomerId(UserStatisticsInfo userStatisticsInfo);

    /**
     * 升级特殊用户
     *
     * @param userStatisticsInfo 门店数据
     * @return 结果
     */
    int updateSpecialUserInfo(UserStatisticsInfo userStatisticsInfo);

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
     String importUser(List<UserStatisticsInfo> userList, Boolean isUpdateSupport);

}
