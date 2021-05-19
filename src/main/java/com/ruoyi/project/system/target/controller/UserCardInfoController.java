package com.ruoyi.project.system.target.controller;

import java.util.List;

import com.ruoyi.project.system.target.domain.UserCardInfo;
import com.ruoyi.project.system.target.service.IUserCardInfoService;
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
 * 学习目标Controller
 *
 * @author wer
 * @date 2021-05-19
 */
@Controller
@RequestMapping("/system/userCard")
public class UserCardInfoController extends BaseController
{
    private String prefix = "system/userCard";

    @Autowired
    private IUserCardInfoService userCardInfoService;

    @GetMapping()
    public String info()
    {
        return prefix + "/userCard";
    }

    /**
     * 查询学习目标列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserCardInfo userCardInfo)
    {
        startPage();
        List<UserCardInfo> list = userCardInfoService.selectUserCardInfoList(userCardInfo);
        return getDataTable(list);
    }

    /**
     * 导出学习目标列表
     */
    @Log(title = "学习目标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserCardInfo userCardInfo)
    {
        List<UserCardInfo> list = userCardInfoService.selectUserCardInfoList(userCardInfo);
        ExcelUtil<UserCardInfo> util = new ExcelUtil<UserCardInfo>(UserCardInfo.class);
        return util.exportExcel(list, "学习目标数据");
    }

    /**
     * 新增学习目标
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学习目标
     */
    @Log(title = "学习目标", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserCardInfo userCardInfo)
    {
        return toAjax(userCardInfoService.insertUserCardInfo(userCardInfo));
    }

    /**
     * 修改学习目标
     */
    @GetMapping("/edit/{cardId}")
    public String edit(@PathVariable("cardId") Long cardId, ModelMap mmap)
    {
        UserCardInfo userCardInfo = userCardInfoService.selectUserCardInfoById(cardId);
        mmap.put("userCardInfo", userCardInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存学习目标
     */
    @Log(title = "学习目标", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserCardInfo userCardInfo)
    {
        return toAjax(userCardInfoService.updateUserCardInfo(userCardInfo));
    }

    /**
     * 删除学习目标
     */
    @Log(title = "学习目标", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userCardInfoService.deleteUserCardInfoByIds(ids));
    }
}
