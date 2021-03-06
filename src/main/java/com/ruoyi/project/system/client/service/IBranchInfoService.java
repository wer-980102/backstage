package com.ruoyi.project.system.client.service;

import com.ruoyi.project.system.client.domain.BranchInfo;

import java.util.List;

/**
 * 分店信息Service接口
 *
 * @author wer
 * @date 2021-04-23
 */
public interface IBranchInfoService
{
    /**
     * 查询分店信息
     *
     * @param userId 分店信息ID
     * @return 分店信息
     */
    String selectBranchInfoById(Long userId);

    /**
     * 查询分店信息
     *
     * @param branchId 分店信息ID
     * @return 分店信息
     */
    BranchInfo getBranchInfoById(Long branchId);

    /**
     * 查询分店信息列表
     *
     * @param branchInfo 分店信息
     * @return 分店信息集合
     */
     List<BranchInfo> selectBranchInfoList(BranchInfo branchInfo);

    /**
     * 新增分店信息
     *
     * @param branchInfo 分店信息
     * @return 结果
     */
     int insertBranchInfo(BranchInfo branchInfo);

    /**
     * 修改分店信息
     *
     * @param branchInfo 分店信息
     * @return 结果
     */
     int updateBranchInfo(BranchInfo branchInfo);

    /**
     * 批量删除分店信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBranchInfoByIds(String ids);

    /**
     * 删除分店信息信息
     *
     * @param branchId 分店信息ID
     * @return 结果
     */
    public int deleteBranchInfoById(Long branchId);
}
