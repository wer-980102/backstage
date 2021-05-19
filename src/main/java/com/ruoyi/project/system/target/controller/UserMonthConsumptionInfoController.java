package com.ruoyi.project.system.target.controller;

import java.util.List;

import com.ruoyi.project.system.target.domain.UserMonthConsumptionInfo;
import com.ruoyi.project.system.target.service.IUserMonthConsumptionInfoService;
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
 * 每月消费流水Controller
 *
 * @author wer
 * @date 2021-05-19
 */
@Controller
@RequestMapping("/system/userMonth")
public class UserMonthConsumptionInfoController extends BaseController
{
    private String prefix = "system/userMonth";

    @Autowired
    private IUserMonthConsumptionInfoService userMonthConsumptionInfoService;

    @GetMapping()
    public String info()
    {
        return prefix + "/userMonth";
    }

    /**
     * 查询每月消费流水列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserMonthConsumptionInfo userMonthConsumptionInfo)
    {
        startPage();
        List<UserMonthConsumptionInfo> list = userMonthConsumptionInfoService.selectUserMonthConsumptionInfoList(userMonthConsumptionInfo);
        return getDataTable(list);
    }

    /**
     * 导出每月消费流水列表
     */
    @Log(title = "每月消费流水", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserMonthConsumptionInfo userMonthConsumptionInfo)
    {
        List<UserMonthConsumptionInfo> list = userMonthConsumptionInfoService.selectUserMonthConsumptionInfoList(userMonthConsumptionInfo);
        ExcelUtil<UserMonthConsumptionInfo> util = new ExcelUtil<UserMonthConsumptionInfo>(UserMonthConsumptionInfo.class);
        return util.exportExcel(list, "每月消费流水数据");
    }

    /**
     * 新增每月消费流水
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存每月消费流水
     */
    @Log(title = "每月消费流水", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserMonthConsumptionInfo userMonthConsumptionInfo)
    {
        return toAjax(userMonthConsumptionInfoService.insertUserMonthConsumptionInfo(userMonthConsumptionInfo));
    }

    /**
     * 修改每月消费流水
     */
    @GetMapping("/edit/{monthConsumptionId}")
    public String edit(@PathVariable("monthConsumptionId") Long monthConsumptionId, ModelMap mmap)
    {
        UserMonthConsumptionInfo userMonthConsumptionInfo = userMonthConsumptionInfoService.selectUserMonthConsumptionInfoById(monthConsumptionId);
        mmap.put("userMonthConsumptionInfo", userMonthConsumptionInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存每月消费流水
     */
    @Log(title = "每月消费流水", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserMonthConsumptionInfo userMonthConsumptionInfo)
    {
        return toAjax(userMonthConsumptionInfoService.updateUserMonthConsumptionInfo(userMonthConsumptionInfo));
    }

    /**
     * 删除每月消费流水
     */
    @Log(title = "每月消费流水", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userMonthConsumptionInfoService.deleteUserMonthConsumptionInfoByIds(ids));
    }
}
