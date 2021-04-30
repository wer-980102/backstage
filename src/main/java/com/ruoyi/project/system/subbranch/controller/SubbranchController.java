package com.ruoyi.project.system.subbranch.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.client.domain.BranchInfo;
import com.ruoyi.project.system.client.service.IBranchInfoService;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.dept.service.IDeptService;
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
    @Autowired
    private IDeptService iDeptService;

    @GetMapping()
    public String info()
    {
        return prefix + "/subbranch";
    }

    /**
     * 查询分店信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dept dept)
    {
        startPage();
        List<Dept> list = null;
        //管理员查全部
        if(CommonUtils.USER_ADMIN.equals(ShiroUtils.getLoginName())){
            list = iDeptService.selectDeptList(dept);
        }else{
            dept.setUserId(ShiroUtils.getUserId());
            list = iDeptService.selectDeptList(dept);

        }
        return getDataTable(list);
    }

    /**
     * 导出分店信息列表
     */
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
     * 新增部门
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        if (!ShiroUtils.getSysUser().isAdmin())
        {
            parentId = ShiroUtils.getSysUser().getDeptId();
        }
        mmap.put("dept", iDeptService.selectDeptById(parentId));
        return prefix + "/add";
    }

    /**
     * 新增保存分店信息
     */
    @Log(title = "分店信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dept dept)
    {
        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals(iDeptService.checkDeptNameUnique(dept)))
        {
            return error("新增分店'" + dept.getDeptName() + "'失败，分店名称已存在");
        }
        dept.setOperator(ShiroUtils.getLoginName());
        return toAjax(iDeptService.insertDept(dept));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{deptId}")
    public String edit(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        Dept dept = iDeptService.selectDeptById(deptId);
        if (StringUtils.isNotNull(dept) && 100L == deptId)
        {
            dept.setParentName("无");
        }
        mmap.put("dept", dept);
        return prefix + "/edit";
    }
    /**
     * 保存
     */
    @Log(title = "分店管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Dept dept)
    {
        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals(iDeptService.checkDeptNameUnique(dept)))
        {
            return error("修改分店'" + dept.getDeptName() + "'失败，分店名称已存在");
        }
        else if (dept.getParentId().equals(dept.getDeptId()))
        {
            return error("修改分店'" + dept.getDeptName() + "'失败，上级分店不能是自己");
        }
        else if (StringUtils.equals(UserConstants.DEPT_DISABLE, dept.getStatus())
                && iDeptService.selectNormalChildrenDeptById(dept.getDeptId()) > 0)
        {
            return AjaxResult.error("该分店包含未停用的子分店！");
        }
        dept.setOperator(ShiroUtils.getLoginName());
        return toAjax(iDeptService.updateDept(dept));
    }

    /**
     * 保存
     */
    @Log(title = "分店管理", businessType = BusinessType.UPDATE)
    @PostMapping("/editStatus")
    @ResponseBody
    public AjaxResult editStatus(@Validated Dept dept)
    {
        return toAjax(iDeptService.updateStatus(dept));
    }
    /**
     * 删除
     */
    @Log(title = "分店信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(@Validated Dept dept)
    {
        if (iDeptService.selectDeptCount(dept.getDeptId()) > 0)
        {
            return AjaxResult.warn("存在下级部门,不允许删除");
        }
        if (iDeptService.checkDeptExistUser(dept.getDeptId()))
        {
            return AjaxResult.warn("部门存在用户,不允许删除");
        }
        return toAjax(iDeptService.deleteDeptById(dept.getDeptId()));
    }

}
