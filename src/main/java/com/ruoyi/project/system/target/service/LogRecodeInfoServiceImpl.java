package com.ruoyi.project.system.target.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.target.domain.LogRecodeInfo;
import com.ruoyi.project.system.target.domain.UserCardInfo;
import com.ruoyi.project.system.target.domain.dto.LogRecodeInfoDto;
import com.ruoyi.project.system.target.domain.dto.UserCardInfoDto;
import com.ruoyi.project.system.target.domain.param.UserCardInfoParam;
import com.ruoyi.project.system.target.mapper.LogRecodeInfoMapper;
import org.apache.commons.lang3.ArrayUtils;
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
    public LogRecodeInfoDto selectLogRecodeInfoById(Long recodeId)
    {
        return logRecodeInfoMapper.selectLogRecodeInfoById(recodeId);
    }

    /**
     * 查询树
     * @param param
     * @return
     */
    @Override
    public UserCardInfoDto getUserCardById(UserCardInfoParam param) {
        return logRecodeInfoMapper.getUserCardById(param);
    }


    /**
     * 查询部门管理树
     *
     * @param info 部门信息
     * @return 所有部门信息
     */
    @Override
    public List<Ztree> selectDeptTree(UserCardInfo info)
    {
        List<UserCardInfoDto> deptList = logRecodeInfoMapper.getUserCardInfo(info);
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }


    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<UserCardInfoDto> deptList)
    {
        return initZtree(deptList, null);
    }


    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @param roleDeptList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<UserCardInfoDto> deptList, List<String> roleDeptList)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleDeptList);
        for (UserCardInfoDto dept : deptList)
        {

                Ztree ztree = new Ztree();
                ztree.setId(Long.valueOf(dept.getCardId()));
                ztree.setName(dept.getStudyTitle());
                ztree.setTitle(dept.getStudyTitle());
                if (isCheck)
                {
                    ztree.setChecked(roleDeptList.contains(dept.getCardId() + dept.getStudyTitle()));
                }
                ztrees.add(ztree);

        }
        return ztrees;
    }

    /**
     * 查询名称是否唯一
     * @param param
     * @return
     */
    @Override
    public boolean getUserCardByName(UserCardInfoParam param) {
        boolean flag = false;
        String userCardByName = logRecodeInfoMapper.getUserCardByName(param);
        if(StringUtils.isNotNull(userCardByName)){
            flag = false;
        }else{
            flag = true;
        }
        return flag;
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
     * 查询所有
     * @param logRecodeInfo
     * @return
     */
    @Override
    public List<LogRecodeInfoDto> getLogRecodeInfo(LogRecodeInfo logRecodeInfo) {
        return logRecodeInfoMapper.getLogRecodeInfo(logRecodeInfo);
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
        logRecodeInfo.setUpdateBy(ShiroUtils.getLoginName());
        return logRecodeInfoMapper.updateLogRecodeInfo(logRecodeInfo);
    }

    /**
     * 修改目标进行状态
     *
     * @param logRecodeInfo 目标进行
     * @return 结果
     */
    @Override
    public int updateLogRecodeStudyExpect(LogRecodeInfo logRecodeInfo) {
        logRecodeInfo.setUpdateTime(DateUtils.getNowDate());
        logRecodeInfo.setUpdateBy(ShiroUtils.getLoginName());
        return logRecodeInfoMapper.updateLogRecodeStudyExpect(logRecodeInfo);
    }

    /**
     * 动态删除
     * @param logRecodeInfo
     * @return
     */
    @Override
    public int updateLogRecodeStatus(LogRecodeInfo logRecodeInfo) {
        logRecodeInfo.setUpdateTime(DateUtils.getNowDate());
        logRecodeInfo.setUpdateBy(ShiroUtils.getLoginName());
        logRecodeInfo.setStatus(CommonUtils.NORMAL_STATUS);
        return logRecodeInfoMapper.updateLogRecodeStatus(logRecodeInfo);
    }

    /**
     * 保存打卡状态
     * @param logRecodeInfo
     * @return
     */
    @Override
    public int updatePunch(LogRecodeInfo logRecodeInfo) {
        return logRecodeInfoMapper.updatePunch(logRecodeInfo);
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
