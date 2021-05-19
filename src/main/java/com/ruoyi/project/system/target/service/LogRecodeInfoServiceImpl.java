package com.ruoyi.project.system.target.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.target.domain.LogRecodeInfo;
import com.ruoyi.project.system.target.mapper.LogRecodeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 目标进行Service业务层处理
 *
 * @author wer
 * @date 2021-05-19
 */
@Service
public class LogRecodeInfoServiceImpl implements ILogRecodeInfoService
{
    @Autowired
    private LogRecodeInfoMapper logRecodeInfoMapper;

    /**
     * 查询目标进行
     *
     * @param recodeId 目标进行ID
     * @return 目标进行
     */
    @Override
    public LogRecodeInfo selectLogRecodeInfoById(Long recodeId)
    {
        return logRecodeInfoMapper.selectLogRecodeInfoById(recodeId);
    }

    /**
     * 查询目标进行列表
     *
     * @param logRecodeInfo 目标进行
     * @return 目标进行
     */
    @Override
    public List<LogRecodeInfo> selectLogRecodeInfoList(LogRecodeInfo logRecodeInfo)
    {
        return logRecodeInfoMapper.selectLogRecodeInfoList(logRecodeInfo);
    }

    /**
     * 新增目标进行
     *
     * @param logRecodeInfo 目标进行
     * @return 结果
     */
    @Override
    public int insertLogRecodeInfo(LogRecodeInfo logRecodeInfo)
    {
        logRecodeInfo.setCreateTime(DateUtils.getNowDate());
        return logRecodeInfoMapper.insertLogRecodeInfo(logRecodeInfo);
    }

    /**
     * 修改目标进行
     *
     * @param logRecodeInfo 目标进行
     * @return 结果
     */
    @Override
    public int updateLogRecodeInfo(LogRecodeInfo logRecodeInfo)
    {
        logRecodeInfo.setUpdateTime(DateUtils.getNowDate());
        return logRecodeInfoMapper.updateLogRecodeInfo(logRecodeInfo);
    }

    /**
     * 删除目标进行对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLogRecodeInfoByIds(String ids)
    {
        return logRecodeInfoMapper.deleteLogRecodeInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除目标进行信息
     *
     * @param recodeId 目标进行ID
     * @return 结果
     */
    @Override
    public int deleteLogRecodeInfoById(Long recodeId)
    {
        return logRecodeInfoMapper.deleteLogRecodeInfoById(recodeId);
    }
}
