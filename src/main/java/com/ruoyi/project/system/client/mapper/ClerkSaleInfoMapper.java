package com.ruoyi.project.system.client.mapper;

import com.ruoyi.project.system.client.domain.ClerkSaleInfo;
import com.ruoyi.project.system.client.domain.dto.ClerkSaleInfoDto;
import com.ruoyi.project.system.client.domain.dto.UserMonthInfoDto;

import java.util.List;

/**
 * 销售纪录Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-16
 */
public interface ClerkSaleInfoMapper
{
    /**
     * 查询销售纪录
     *
     * @param saleId 销售纪录ID
     * @return 销售纪录
     */
    public ClerkSaleInfo selectClerkSaleInfoById(Long saleId);

    /**
     *  根据那么查询
     * @param customer
     * @return
     */
    ClerkSaleInfo getClerkSaleInfo(String customer);

    /**
     * 计算用户累计销售额
     * @param customerId
     * @return
     */
    Integer getActualSalesInfo(Long customerId);

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
     * 修改销售纪录
     *
     * @param clerkSaleInfo 销售纪录
     * @return 结果
     */
     int updateClerkSaleInfo(ClerkSaleInfo clerkSaleInfo);
    /**
     * 根据客户ID修改销售纪录
     *
     * @param clerkSaleInfo 销售纪录
     * @return 结果
     */
    int updateClerkSaleByCustomerId(ClerkSaleInfo clerkSaleInfo);
    /**
     * 删除销售纪录
     *
     * @param saleId 销售纪录ID
     * @return 结果
     */
     int deleteClerkSaleInfoById(Long saleId);

    /**
     * 批量删除销售纪录
     *
     * @param saleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteClerkSaleInfoByIds(String[] saleIds);
}
