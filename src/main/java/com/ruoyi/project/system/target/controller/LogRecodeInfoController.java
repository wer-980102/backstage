package com.ruoyi.project.system.target.controller;

import java.util.List;

import com.ruoyi.project.system.target.domain.LogRecodeInfo;
import com.ruoyi.project.system.target.service.ILogRecodeInfoService;
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
 * 目标进行Controller
 *
 * @author wer
 * @date 2021-05-19
 */
@Controller
@RequestMapping("/system/logRecode")
public class LogRecodeInfoController extends BaseController
{
    private String prefix = "system/logRecode";

    @Autowired
    private ILogRecodeInfoService logRecodeInfoService;

    @GetMapping()
    public String info()
    {
        return prefix + "/logRecode";
    }

    /**
     * 查询目标进行列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LogRecodeInfo logRecodeInfo)
    {
        startPage();
        List<LogRecodeInfo> list = logRecodeInfoService.selectLogRecodeInfoList(logRecodeInfo);
        return getDataTable(list);
    }

    /**
     * 导出目标进行列表
     */
    @Log(title = "目标进行", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LogRecodeInfo logRecodeInfo)
    {
        List<LogRecodeInfo> list = logRecodeInfoService.selectLogRecodeInfoList(logRecodeInfo);
        ExcelUtil<LogRecodeInfo> util = new ExcelUtil<LogRecodeInfo>(LogRecodeInfo.class);
        return util.exportExcel(list, "目标进行数据");
    }

    /**
     * 新增目标进行
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存目标进行
     */
    @Log(title = "目标进行", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LogRecodeInfo logRecodeInfo)
    {
        return toAjax(logRecodeInfoService.insertLogRecodeInfo(logRecodeInfo));
    }

    /**
     * 修改目标进行
     */
    @GetMapping("/edit/{recodeId}")
    public String edit(@PathVariable("recodeId") Long recodeId, ModelMap mmap)
    {
        LogRecodeInfo logRecodeInfo = logRecodeInfoService.selectLogRecodeInfoById(recodeId);
        mmap.put("logRecodeInfo", logRecodeInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存目标进行
     */
    @Log(title = "目标进行", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LogRecodeInfo logRecodeInfo)
    {
        return toAjax(logRecodeInfoService.updateLogRecodeInfo(logRecodeInfo));
    }

    /**
     * 修改保存目标进行
     */
    @Log(title = "目标进行", businessType = BusinessType.UPDATE)
    @PostMapping("/editRecode")
    @ResponseBody
    public AjaxResult editRecode(LogRecodeInfo logRecodeInfo)
    {
        return toAjax(logRecodeInfoService.updateLogRecodeStudyExpect(logRecodeInfo));
    }

    /**
     * 删除目标进行
     */
    @Log(title = "目标进行", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(logRecodeInfoService.deleteLogRecodeInfoByIds(ids));
    }

    /**
     * 删除目标进行
     */
    @Log(title = "目标进行", businessType = BusinessType.DELETE)
    @PostMapping( "/removeStatus")
    @ResponseBody
    public AjaxResult removeStatus(LogRecodeInfo logRecodeInfo)
    {
        return toAjax(logRecodeInfoService.updateLogRecodeStatus(logRecodeInfo));
    }
}
