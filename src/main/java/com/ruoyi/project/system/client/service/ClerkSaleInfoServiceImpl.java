package com.ruoyi.project.system.client.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.client.domain.ClerkSaleInfo;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.mapper.ClerkSaleInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(UserStatisticsInfoServiceImpl.class);
    @Autowired
    private ClerkSaleInfoMapper clerkSaleInfoMapper;
    @Autowired
    private IUserStatisticsInfoService iUserStatisticsInfoService;

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


    /**
     * 导入用户数据
     *
     * @param saleInfoList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    @Override
    public String importUser(List<ClerkSaleInfo> saleInfoList, Boolean isUpdateSupport)
    {
        if (StringUtils.isNull(saleInfoList) || saleInfoList.size() == 0)
        {
            throw new BusinessException("导入销售数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (ClerkSaleInfo sale : saleInfoList)
        {
            try
            {
                UserStatisticsInfo user = iUserStatisticsInfoService.getUserById(sale.getCustomer());
                //判断有没有用户
                if(user!= null){
                    if (StringUtils.isNotEmpty(sale.getCustomer()))
                    {
                        if(StringUtils.isNotEmpty(sale.getLastGoods())){
                            user.setOperatorTime("20"+sale.getLastGoods());
                        }
                        sale.setCreateBy(user.getOperator());
                        sale.setCustomerId(user.getStatisticsId());
                        this.insertClerkSaleInfo(sale);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、账号 " + sale.getCustomer() + " 导入成功");
                    }
                    else if (isUpdateSupport)
                    {
                        user.setUpdateBy(user.getOperator());
                        this.updateClerkSaleInfo(sale);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、账号 " + sale.getCustomer() + " 更新成功");
                    }
                    else
                    {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、账号 " + sale.getCustomer() + " 已存在");
                    }
                }else{
                    failureMsg.insert(0, "没有该用户，请先导入用户数据！");
                    throw new BusinessException(failureMsg.toString());
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + sale.getCustomer() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
