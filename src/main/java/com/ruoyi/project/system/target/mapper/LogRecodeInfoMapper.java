package com.ruoyi.project.system.target.mapper;

import com.ruoyi.project.system.target.domain.LogRecodeInfo;
import com.ruoyi.project.system.target.domain.UserCardInfo;
import com.ruoyi.project.system.target.domain.dto.LogRecodeInfoDto;
import com.ruoyi.project.system.target.domain.dto.UserCardInfoDto;
import com.ruoyi.project.system.target.domain.param.UserCardInfoParam;

import java.util.List;

/**
 * 目标进行Mapper接口
 *
 * @author wer
 * @date 2021-05-19
 */
public interface LogRecodeInfoMapper
{
    /**
     * 查询目标进行
     *
     * @param recodeId 目标进行ID
     * @return 目标进行
     */
     LogRecodeInfoDto selectLogRecodeInfoById(Long recodeId);

    /**
     * 查询树
     * @param param
     * @return
     */
    UserCardInfoDto getUserCardById(UserCardInfoParam param);

    /**
     * 查询树
     * @param param
     * @return
     */
    List<UserCardInfoDto> getUserCardInfo(UserCardInfo param);

    /**
     * 查询名称是否唯一
     * @param param
     * @return
     */
    String getUserCardByName(UserCardInfoParam param);

    /**
     * 查询目标进行列表
     *
     * @param logRecodeInfo 目标进行
     * @return 目标进行集合
     */
     List<LogRecodeInfo> selectLogRecodeInfoList(LogRecodeInfo logRecodeInfo);

    /**
     * 查询所有
     * @param logRecodeInfo
     * @return
     */
     List<LogRecodeInfoDto> getLogRecodeInfo(LogRecodeInfo logRecodeInfo);

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
     * 修改目标进行状态
     *
     * @param logRecodeInfo 目标进行
     * @return 结果
     */
    int updateLogRecodeStudyExpect(LogRecodeInfo logRecodeInfo);

    /**
     * 动态删除
     * @param logRecodeInfo
     * @return
     */
    int updateLogRecodeStatus(LogRecodeInfo logRecodeInfo);

    /**
     * 保存打卡状态
     * @param logRecodeInfo
     * @return
     */
    int updatePunch(LogRecodeInfo logRecodeInfo);

    /**
     * 删除目标进行
     *
     * @param recodeId 目标进行ID
     * @return 结果
     */
    public int deleteLogRecodeInfoById(Long recodeId);

    /**
     * 批量删除目标进行
     *
     * @param recodeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLogRecodeInfoByIds(String[] recodeIds);
}
