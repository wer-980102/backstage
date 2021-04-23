package com.ruoyi.project.system.client.service;

import com.ruoyi.project.system.client.domain.ClerkSaleInfo;
import com.ruoyi.project.system.client.domain.dto.UserMonthInfoDto;

import java.util.List;

/**
 * 销售纪录Service接口
 *
 * @author ruoyi
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
    public List<ClerkSaleInfo> selectClerkSaleInfoList(ClerkSaleInfo clerkSaleInfo);


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
    public int updateClerkSaleInfo(ClerkSaleInfo clerkSaleInfo);

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
