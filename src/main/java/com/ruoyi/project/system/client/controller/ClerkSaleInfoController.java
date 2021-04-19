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
import org.springframework.web.multipart.MultipartFile;

/**
 * 销售纪录Controller
 *
 * @author ruoyi
 * @date 2021-04-16
 */
@Controller
@RequestMapping("/system/sale")
public class ClerkSaleInfoController extends BaseController
{
    private String prefix = "system/sale";

    @Autowired
    private IClerkSaleInfoService clerkSaleInfoService;

    @RequiresPermissions("system:sale:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/sale";
    }

    /**
     * 查询销售纪录列表
     */
    @RequiresPermissions("system:sale:list")
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
    @RequiresPermissions("system:sale:export")
    @Log(title = "销售纪录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClerkSaleInfo clerkSaleInfo)
    {
        List<ClerkSaleInfo> list = clerkSaleInfoService.selectClerkSaleInfoList(clerkSaleInfo);
        ExcelUtil<ClerkSaleInfo> util = new ExcelUtil<ClerkSaleInfo>(ClerkSaleInfo.class);
        return util.exportExcel(list, "销售纪录数据");
    }
    @RequiresPermissions("system:sale:view")
    @GetMapping("/saleimportTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<ClerkSaleInfo> util = new ExcelUtil<ClerkSaleInfo>(ClerkSaleInfo.class);
        return util.importTemplateExcel("后台数据");
    }

    @Log(title = "销售导入", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:sale:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ClerkSaleInfo> util = new ExcelUtil<ClerkSaleInfo>(ClerkSaleInfo.class);
        List<ClerkSaleInfo> saleInfoList = util.importExcel(file.getInputStream());
        String message =clerkSaleInfoService.importUser(saleInfoList, updateSupport);
        return AjaxResult.success(message);
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
    @RequiresPermissions("system:sale:add")
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
    @RequiresPermissions("system:sale:edit")
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
    @RequiresPermissions("system:sale:remove")
    @Log(title = "销售纪录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(clerkSaleInfoService.deleteClerkSaleInfoByIds(ids));
    }
}
