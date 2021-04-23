package com.ruoyi.project.system.client.mapper;

import com.ruoyi.project.system.client.domain.ClerkSaleInfo;
import com.ruoyi.project.system.client.domain.NotClerkSaleInfo;

import java.util.List;

/**
 * 未注册人的销售纪录Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-23
 */
public interface NotClerkSaleInfoMapper
{
    /**
     * 查询未注册人的销售纪录
     *
     * @param saleId 未注册人的销售纪录ID
     * @return 未注册人的销售纪录
     */
    public NotClerkSaleInfo selectNotClerkSaleInfoById(Long saleId);

    /**
     * 查询未注册人的销售纪录列表
     *
     * @param notClerkSaleInfo 未注册人的销售纪录
     * @return 未注册人的销售纪录集合
     */
    public List<NotClerkSaleInfo> selectNotClerkSaleInfoList(NotClerkSaleInfo notClerkSaleInfo);

    /**
     * 新增未注册人的销售纪录
     *
     * @param notClerkSaleInfo 未注册人的销售纪录
     * @return 结果
     */
     int insertNotClerkSaleInfo(ClerkSaleInfo clerkSaleInfo);

    /**
     * 修改未注册人的销售纪录
     *
     * @param notClerkSaleInfo 未注册人的销售纪录
     * @return 结果
     */
    public int updateNotClerkSaleInfo(NotClerkSaleInfo notClerkSaleInfo);

    /**
     * 删除未注册人的销售纪录
     *
     * @param saleId 未注册人的销售纪录ID
     * @return 结果
     */
    public int deleteNotClerkSaleInfoById(Long saleId);

    /**
     * 批量删除未注册人的销售纪录
     *
     * @param saleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNotClerkSaleInfoByIds(String[] saleIds);
}
