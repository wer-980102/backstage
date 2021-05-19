package com.ruoyi.project.system.target.service;

import com.ruoyi.project.system.target.domain.LogRecodeInfo;

import java.util.List;

/**
 * 目标进行Service接口
 *
 * @author wer
 * @date 2021-05-19
 */
public interface ILogRecodeInfoService
{
    /**
     * 查询目标进行
     *
     * @param recodeId 目标进行ID
     * @return 目标进行
     */
    public LogRecodeInfo selectLogRecodeInfoById(Long recodeId);

    /**
     * 查询目标进行列表
     *
     * @param logRecodeInfo 目标进行
     * @return 目标进行集合
     */
    public List<LogRecodeInfo> selectLogRecodeInfoList(LogRecodeInfo logRecodeInfo);

    /**
     * 新增目标进行
     *
     * @param logRecodeInfo 目标进行
     * @return 结果
     */
    public int insertLogRecodeInfo(LogRecodeInfo logRecodeInfo);

    /**
     * 修改目标进行
     *
     * @param logRecodeInfo 目标进行
     * @return 结果
     */
    public int updateLogRecodeInfo(LogRecodeInfo logRecodeInfo);

    /**
     * 批量删除目标进行
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLogRecodeInfoByIds(String ids);

    /**
     * 删除目标进行信息
     *
     * @param recodeId 目标进行ID
     * @return 结果
     */
    public int deleteLogRecodeInfoById(Long recodeId);
}
