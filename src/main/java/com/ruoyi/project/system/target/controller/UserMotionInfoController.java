package com.ruoyi.project.system.target.controller;

import java.util.List;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.target.domain.UserMotionInfo;
import com.ruoyi.project.system.target.domain.dto.LogRecodeInfoDto;
import com.ruoyi.project.system.target.service.IUserMotionInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 运动信息Controller
 *
 * @author wer
 * @date 2021-05-19
 */
@Controller
@RequestMapping("/system/motionInfo")
public class UserMotionInfoController extends BaseController
{
    private String prefix = "system/motionInfo";

    @Autowired
    private IUserMotionInfoService userMotionInfoService;

    @GetMapping()
    public String info()
    {
        return prefix + "/motionInfo";
    }

    /**
     * 查询运动信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserMotionInfo userMotionInfo)
    {
        startPage();
        List<UserMotionInfo> list = null;
        //管理员查全部
        if(CommonUtils.USER_ADMIN.equals(ShiroUtils.getLoginName())){
            list = userMotionInfoService.selectUserMotionInfoList(userMotionInfo);
        }else{
            userMotionInfo.setUserId(ShiroUtils.getUserId());
            list = userMotionInfoService.selectUserMotionInfoList(userMotionInfo);
        }
        return getDataTable(list);
    }

    /**
     * 导出运动信息列表
     */
    @Log(title = "运动信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserMotionInfo userMotionInfo)
    {
        List<UserMotionInfo> list = userMotionInfoService.selectUserMotionInfoList(userMotionInfo);
        ExcelUtil<UserMotionInfo> util = new ExcelUtil<UserMotionInfo>(UserMotionInfo.class);
        return util.exportExcel(list, "运动信息数据");
    }

    /**
     * 新增运动信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存运动信息
     */
    @Log(title = "运动信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserMotionInfo userMotionInfo)
    {
        return toAjax(userMotionInfoService.insertUserMotionInfo(userMotionInfo));
    }

    /**
     * 修改运动信息
     */
    @GetMapping("/edit/{motionId}")
    public String edit(@PathVariable("motionId") Long motionId, ModelMap mmap)
    {
        UserMotionInfo userMotionInfo = userMotionInfoService.selectUserMotionInfoById(motionId);
        mmap.put("userMotionInfo", userMotionInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存运动信息
     */
    @Log(title = "运动信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserMotionInfo userMotionInfo)
    {
        return toAjax(userMotionInfoService.updateUserMotionInfo(userMotionInfo));
    }

    /**
     * 修改状态
     */
    @Log(title = "运动信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateUserMotionStandardStatus")
    @ResponseBody
    public AjaxResult updateUserMotionStandardStatus(UserMotionInfo userMotionInfo)
    {
        return toAjax(userMotionInfoService.updateUserMotionStandardStatus(userMotionInfo));
    }

    /**
     * 动态删除
     */
    @Log(title = "运动信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateUserStatus")
    @ResponseBody
    public AjaxResult updateUserStatus(UserMotionInfo userMotionInfo)
    {
        return toAjax(userMotionInfoService.updateUserStatus(userMotionInfo));
    }

    /**
     * 删除运动信息
     */
    @Log(title = "运动信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userMotionInfoService.deleteUserMotionInfoByIds(ids));
    }
}
