package com.ruoyi.project.system.client.mapper;

import com.ruoyi.project.system.client.domain.BranchInfo;

import java.util.List;

/**
 * 分店信息Mapper接口
 *
 * @author wer
 * @date 2021-04-23
 */
public interface BranchInfoMapper
{
    /**
     * 查询分店信息
     *
     * @param branchId 分店信息ID
     * @return 分店信息
     */
    public BranchInfo selectBranchInfoById(Long branchId);

    /**
     * 查询分店信息列表
     *
     * @param branchInfo 分店信息
     * @return 分店信息集合
     */
    public List<BranchInfo> selectBranchInfoList(BranchInfo branchInfo);

    /**
     * 新增分店信息
     *
     * @param branchInfo 分店信息
     * @return 结果
     */
    public int insertBranchInfo(BranchInfo branchInfo);

    /**
     * 修改分店信息
     *
     * @param branchInfo 分店信息
     * @return 结果
     */
    public int updateBranchInfo(BranchInfo branchInfo);

    /**
     * 删除分店信息
     *
     * @param branchId 分店信息ID
     * @return 结果
     */
    public int deleteBranchInfoById(Long branchId);

    /**
     * 批量删除分店信息
     *
     * @param branchIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBranchInfoByIds(String[] branchIds);
}
