package com.ruoyi.project.system.statistics.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.post.service.IPostService;
import com.ruoyi.project.system.role.service.IRoleService;
import com.ruoyi.project.system.statistics.domain.UserInfo;
import com.ruoyi.project.system.statistics.service.IStatisticsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户信息
 * 
 * @author wer
 */
@Controller
@RequestMapping("/system/statistics")
public class SatisticsController extends BaseController
{
    private String prefix = "system/statistics";

    @Autowired
    private IStatisticsService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPostService postService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserInfo user)
    {
        startPage();
        List<UserInfo> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "信息导出", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:user:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserInfo user)
    {
        List<UserInfo> list = userService.selectUserList(user);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        return util.exportExcel(list, "用户数据");
    }

    @Log(title = "信息导入", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:user:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        List<UserInfo> userList = util.importExcel(file.getInputStream());
        String message = userService.importUser(userList, updateSupport);
        return AjaxResult.success(message);
    }



    @RequiresPermissions("system:user:remove")
    @Log(title = "信息删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long ids)
    {
        return toAjax(userService.deleteUserByIds(ids));
    }


}