package com.ruoyi.project.system.subbranch.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.client.domain.BranchInfo;
import com.ruoyi.project.system.client.service.IBranchInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
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
 * 分店信息Controller
 *
 * @author wer
 * @date 2021-04-23
 */
@Controller
@RequestMapping("/system/subbranch")
public class SubbranchController extends BaseController
{
    private String prefix = "system/subbranch";

    @Autowired
    private IBranchInfoService branchInfoService;

    @RequiresPermissions("system:subbranch:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/subbranch";
    }

    /**
     * 查询分店信息列表
     */
    @RequiresPermissions("system:subbranch:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BranchInfo branchInfo)
    {
        startPage();
        List<BranchInfo> list = null;
        //管理员查全部
        if(CommonUtils.USER_ADMIN.equals(ShiroUtils.getLoginName())){
            list = branchInfoService.selectBranchInfoList(branchInfo);
        }else{
            branchInfo.setUserId(ShiroUtils.getUserId());
            list = branchInfoService.selectBranchInfoList(branchInfo);
        }
        return getDataTable(list);
    }

    /**
     * 导出分店信息列表
     */
    @RequiresPermissions("system:subbranch:export")
    @Log(title = "分店信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BranchInfo branchInfo)
    {
        List<BranchInfo> list = branchInfoService.selectBranchInfoList(branchInfo);
        ExcelUtil<BranchInfo> util = new ExcelUtil<BranchInfo>(BranchInfo.class);
        return util.exportExcel(list, "分店信息数据");
    }

    /**
     * 新增分店信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分店信息
     */
    @RequiresPermissions("system:subbranch:add")
    @Log(title = "分店信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BranchInfo branchInfo)
    {
        return toAjax(branchInfoService.insertBranchInfo(branchInfo));
    }

    /**
     * 修改分店信息
     */
    @GetMapping("/edit/{branchId}")
    public String edit(@PathVariable("branchId") Long branchId, ModelMap mmap)
    {
        BranchInfo branchInfo = branchInfoService.getBranchInfoById(branchId);
        mmap.put("branchInfo", branchInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存分店信息
     */
    @RequiresPermissions("system:subbranch:edit")
    @Log(title = "分店信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated BranchInfo branchInfo)
    {
        return toAjax(branchInfoService.updateBranchInfo(branchInfo));
    }

    /**
     * 删除分店信息
     */
    @RequiresPermissions("system:subbranch:remove")
    @Log(title = "分店信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(branchInfoService.deleteBranchInfoByIds(ids));
    }
}
