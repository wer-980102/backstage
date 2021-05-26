package com.ruoyi.project.system.target.controller;

import java.util.List;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.target.domain.UserCardInfo;
import com.ruoyi.project.system.target.domain.UserDayConsumptionInfo;
import com.ruoyi.project.system.target.service.IUserDayConsumptionInfoService;
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
 * 每日消费流水Controller
 *
 * @author wer
 * @date 2021-05-19
 */
@Controller
@RequestMapping("/system/userDay")
public class UserDayConsumptionInfoController extends BaseController
{
    private String prefix = "system/userDay";

    @Autowired
    private IUserDayConsumptionInfoService userDayConsumptionInfoService;

    @GetMapping()
    public String info()
    {
        return prefix + "/userDay";
    }

    /**
     * 查询每日消费流水列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserDayConsumptionInfo userDayConsumptionInfo)
    {
        startPage();
        List<UserDayConsumptionInfo> list = null;
        //管理员查全部
        if(CommonUtils.USER_ADMIN.equals(ShiroUtils.getLoginName())){
            list = userDayConsumptionInfoService.selectUserDayConsumptionInfoList(userDayConsumptionInfo);
        }else{
            userDayConsumptionInfo.setUserId(ShiroUtils.getUserId());
            list = userDayConsumptionInfoService.selectUserDayConsumptionInfoList(userDayConsumptionInfo);
        }
        return getDataTable(list);
    }

    /**
     * 导出每日消费流水列表
     */
    @Log(title = "每日消费流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserDayConsumptionInfo userDayConsumptionInfo)
    {
        List<UserDayConsumptionInfo> list = userDayConsumptionInfoService.selectUserDayConsumptionInfoList(userDayConsumptionInfo);
        ExcelUtil<UserDayConsumptionInfo> util = new ExcelUtil<UserDayConsumptionInfo>(UserDayConsumptionInfo.class);
        return util.exportExcel(list, "每日消费流水数据");
    }

    /**
     * 新增每日消费流水
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存每日消费流水
     */
    @Log(title = "每日消费流水", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserDayConsumptionInfo userDayConsumptionInfo)
    {
        return toAjax(userDayConsumptionInfoService.insertUserDayConsumptionInfo(userDayConsumptionInfo));
    }

    /**
     * 修改每日消费流水
     */
    @GetMapping("/edit/{dayConsumptionId}")
    public String edit(@PathVariable("dayConsumptionId") Long dayConsumptionId, ModelMap mmap)
    {
        UserDayConsumptionInfo userDayConsumptionInfo = userDayConsumptionInfoService.selectUserDayConsumptionInfoById(dayConsumptionId);
        mmap.put("userDayConsumptionInfo", userDayConsumptionInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存每日消费流水
     */
    @Log(title = "每日消费流水", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserDayConsumptionInfo userDayConsumptionInfo)
    {
        return toAjax(userDayConsumptionInfoService.updateUserDayConsumptionInfo(userDayConsumptionInfo));
    }

    /**
     * 修改保存每日消费流水
     */
    @Log(title = "每日消费流水", businessType = BusinessType.UPDATE)
    @PostMapping("/editConsumptionStatus")
    @ResponseBody
    public AjaxResult editConsumptionStatus(UserDayConsumptionInfo userDayConsumptionInfo)
    {
        return toAjax(userDayConsumptionInfoService.updateUserDayConsumptionStatus(userDayConsumptionInfo));
    }

    /**
     * 删除每日消费流水
     */
    @Log(title = "每日消费流水", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userDayConsumptionInfoService.deleteUserDayConsumptionInfoByIds(ids));
    }

    /**
     * 修改保存每日消费流水-动态删除
     */
    @Log(title = "每日消费流水", businessType = BusinessType.UPDATE)
    @PostMapping("/updateUserDayStatus")
    @ResponseBody
    public AjaxResult updateUserDayStatus(UserDayConsumptionInfo userDayConsumptionInfo)
    {
        return toAjax(userDayConsumptionInfoService.updateUserDayStatus(userDayConsumptionInfo));
    }
}
