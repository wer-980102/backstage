package com.ruoyi.project.system.client.controller;

import java.util.List;

import com.ruoyi.project.system.client.domain.ClerkSaleInfo;
import com.ruoyi.project.system.client.service.IClerkSaleInfoService;
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
 * 销售纪录Controller
 *
 * @author ruoyi
 * @date 2021-04-16
 */
@Controller
@RequestMapping("/system/info")
public class ClerkSaleInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private IClerkSaleInfoService clerkSaleInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询销售纪录列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ClerkSaleInfo clerkSaleInfo)
    {
        startPage();
        List<ClerkSaleInfo> list = clerkSaleInfoService.selectClerkSaleInfoList(clerkSaleInfo);
        return getDataTable(list);
    }

    /**
     * 导出销售纪录列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "销售纪录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClerkSaleInfo clerkSaleInfo)
    {
        List<ClerkSaleInfo> list = clerkSaleInfoService.selectClerkSaleInfoList(clerkSaleInfo);
        ExcelUtil<ClerkSaleInfo> util = new ExcelUtil<ClerkSaleInfo>(ClerkSaleInfo.class);
        return util.exportExcel(list, "销售纪录数据");
    }

    /**
     * 新增销售纪录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存销售纪录
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "销售纪录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClerkSaleInfo clerkSaleInfo)
    {
        return toAjax(clerkSaleInfoService.insertClerkSaleInfo(clerkSaleInfo));
    }

    /**
     * 修改销售纪录
     */
    @GetMapping("/edit/{saleId}")
    public String edit(@PathVariable("saleId") Long saleId, ModelMap mmap)
    {
        ClerkSaleInfo clerkSaleInfo = clerkSaleInfoService.selectClerkSaleInfoById(saleId);
        mmap.put("clerkSaleInfo", clerkSaleInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存销售纪录
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "销售纪录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClerkSaleInfo clerkSaleInfo)
    {
        return toAjax(clerkSaleInfoService.updateClerkSaleInfo(clerkSaleInfo));
    }

    /**
     * 删除销售纪录
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "销售纪录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(clerkSaleInfoService.deleteClerkSaleInfoByIds(ids));
    }
}
