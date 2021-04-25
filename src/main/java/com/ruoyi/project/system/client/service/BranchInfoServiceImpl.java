package com.ruoyi.project.system.client.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.client.domain.BranchInfo;
import com.ruoyi.project.system.client.mapper.BranchInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.text.Convert;

/**
 * 分店信息Service业务层处理
 *
 * @author wer
 * @date 2021-04-23
 */
@Service
public class BranchInfoServiceImpl implements IBranchInfoService
{
    @Autowired
    private BranchInfoMapper branchInfoMapper;

    /**
     * 查询分店信息
     *
     * @param userId 分店信息ID
     * @return 分店信息
     */
    @Override
    public BranchInfo selectBranchInfoById(Long userId)
    {
        return branchInfoMapper.selectBranchInfoById(userId);
    }

    /**
     * 查询分店信息
     *
     * @param branchId 分店信息ID
     * @return 分店信息
     */
    @Override
    public BranchInfo getBranchInfoById(Long branchId) {
        return branchInfoMapper.getBranchInfoById(branchId);
    }

    /**
     * 查询分店信息列表
     *
     * @param branchInfo 分店信息
     * @return 分店信息
     */
    @Override
    public List<BranchInfo> selectBranchInfoList(BranchInfo branchInfo)
    {
        return branchInfoMapper.selectBranchInfoList(branchInfo);
    }

    /**
     * 新增分店信息
     *
     * @param branchInfo 分店信息
     * @return 结果
     */
    @Override
    public int insertBranchInfo(BranchInfo branchInfo)
    {
        branchInfo.setCreateTime(DateUtils.getNowDate());
        return branchInfoMapper.insertBranchInfo(branchInfo);
    }

    /**
     * 修改分店信息
     *
     * @param branchInfo 分店信息
     * @return 结果
     */
    @Override
    public int updateBranchInfo(BranchInfo branchInfo)
    {
        branchInfo.setUpdateTime(DateUtils.getNowDate());
        return branchInfoMapper.updateBranchInfo(branchInfo);
    }

    /**
     * 删除分店信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBranchInfoByIds(String ids)
    {
        return branchInfoMapper.deleteBranchInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分店信息信息
     *
     * @param branchId 分店信息ID
     * @return 结果
     */
    @Override
    public int deleteBranchInfoById(Long branchId)
    {
        return branchInfoMapper.deleteBranchInfoById(branchId);
    }
}
