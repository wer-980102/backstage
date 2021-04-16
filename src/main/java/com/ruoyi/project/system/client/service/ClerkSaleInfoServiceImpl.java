package com.ruoyi.project.system.client.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.client.domain.ClerkSaleInfo;
import com.ruoyi.project.system.client.mapper.ClerkSaleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 销售纪录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-16
 */
@Service
public class ClerkSaleInfoServiceImpl implements IClerkSaleInfoService
{
    @Autowired
    private ClerkSaleInfoMapper clerkSaleInfoMapper;

    /**
     * 查询销售纪录
     *
     * @param saleId 销售纪录ID
     * @return 销售纪录
     */
    @Override
    public ClerkSaleInfo selectClerkSaleInfoById(Long saleId)
    {
        return clerkSaleInfoMapper.selectClerkSaleInfoById(saleId);
    }

    /**
     * 查询销售纪录列表
     *
     * @param clerkSaleInfo 销售纪录
     * @return 销售纪录
     */
    @Override
    public List<ClerkSaleInfo> selectClerkSaleInfoList(ClerkSaleInfo clerkSaleInfo)
    {
        return clerkSaleInfoMapper.selectClerkSaleInfoList(clerkSaleInfo);
    }

    /**
     * 新增销售纪录
     *
     * @param clerkSaleInfo 销售纪录
     * @return 结果
     */
    @Override
    public int insertClerkSaleInfo(ClerkSaleInfo clerkSaleInfo)
    {
        clerkSaleInfo.setCreateTime(DateUtils.getNowDate());
        return clerkSaleInfoMapper.insertClerkSaleInfo(clerkSaleInfo);
    }

    /**
     * 修改销售纪录
     *
     * @param clerkSaleInfo 销售纪录
     * @return 结果
     */
    @Override
    public int updateClerkSaleInfo(ClerkSaleInfo clerkSaleInfo)
    {
        clerkSaleInfo.setUpdateTime(DateUtils.getNowDate());
        return clerkSaleInfoMapper.updateClerkSaleInfo(clerkSaleInfo);
    }

    /**
     * 删除销售纪录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteClerkSaleInfoByIds(String ids)
    {
        return clerkSaleInfoMapper.deleteClerkSaleInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除销售纪录信息
     *
     * @param saleId 销售纪录ID
     * @return 结果
     */
    @Override
    public int deleteClerkSaleInfoById(Long saleId)
    {
        return clerkSaleInfoMapper.deleteClerkSaleInfoById(saleId);
    }
}
