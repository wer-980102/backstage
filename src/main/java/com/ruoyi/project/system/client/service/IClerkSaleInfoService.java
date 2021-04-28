package com.ruoyi.project.system.client.service;

import com.ruoyi.project.system.client.domain.ClerkSaleInfo;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.ClerkSaleInfoDto;
import com.ruoyi.project.system.client.domain.dto.UserMonthInfoDto;

import java.util.List;

/**
 * 销售纪录Service接口
 *
 * @author wer
 * @date 2021-04-16
 */
public interface IClerkSaleInfoService
{
    /**
     * 查询销售纪录
     *
     * @param saleId 销售纪录ID
     * @return 销售纪录
     */
    public ClerkSaleInfo selectClerkSaleInfoById(Long saleId);

    /**
     * 查询销售纪录列表
     *
     * @param clerkSaleInfo 销售纪录
     * @return 销售纪录集合
     */
     List<ClerkSaleInfo> selectClerkSaleInfoList(ClerkSaleInfo clerkSaleInfo);


    /**
     * 计算最后一次拿货时间
     * @param customerId
     * @return
     */
    ClerkSaleInfoDto getLastGoodsInfo(String customerId);

    /**
     * 新增销售纪录
     *
     * @param clerkSaleInfo 销售纪录
     * @return 结果
     */
    public int insertClerkSaleInfo(ClerkSaleInfo clerkSaleInfo);

    /**
     * 修根据客户ID改销售纪录
     *
     * @param userStatisticsInfo 销售纪录
     * @return 结果
     */
     int updateClerkSaleByIdInfo(UserStatisticsInfo userStatisticsInfo);

    /**
     * 修改销售纪录
     *
     * @param clerkSaleInfo 销售纪录
     * @return 结果
     */
     int updateClerkSaleInfo(ClerkSaleInfo clerkSaleInfo);

    /**
     * 批量删除销售纪录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteClerkSaleInfoByIds(String ids);

    /**
     * 删除销售纪录信息
     *
     * @param saleId 销售纪录ID
     * @return 结果
     */
     int deleteClerkSaleInfoById(Long saleId);

    /**
     * 导入销售数据
     *
     * @param saleInfoList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
     String importUser(List<ClerkSaleInfo> saleInfoList, Boolean isUpdateSupport);
}
