package com.ruoyi.project.system.client.controller;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.system.client.domain.UserIntegralInfo;
import com.ruoyi.project.system.client.service.IUserIntegralInfoService;
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
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 积分规则Controller
 *
 * @author wer
 * @date 2021-04-22
 */
@Controller
@RequestMapping("/system/update")
public class UserIntegralInfoController extends BaseController
{
    private String prefix = "system/update";

    @Autowired
    private IUserIntegralInfoService userIntegralInfoService;

    @GetMapping()
    public String info()
    {
        return prefix + "/update";
    }

    /**
     * 查询积分规则列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserIntegralInfo userIntegralInfo)
    {
        startPage();
        List<UserIntegralInfo> list = userIntegralInfoService.selectUserIntegralInfoList(userIntegralInfo);
        return getDataTable(list);
    }

    /**
     * 导出积分规则列表
     */
    @Log(title = "积分规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserIntegralInfo userIntegralInfo)
    {
        List<UserIntegralInfo> list = userIntegralInfoService.selectUserIntegralInfoList(userIntegralInfo);
        ExcelUtil<UserIntegralInfo> util = new ExcelUtil<UserIntegralInfo>(UserIntegralInfo.class);
        return util.exportExcel(list, "积分规则数据");
    }

    /**
     * 修改积分规则
     */
    @GetMapping("/edit/{integralId}")
    public String edit(@PathVariable("integralId") Long integralId, ModelMap mmap)
    {
        UserIntegralInfo userIntegralInfo = userIntegralInfoService.selectUserIntegralInfoById(integralId);
        if(StringUtils.isEmpty(userIntegralInfo.getChangeName())){
            userIntegralInfo.setChangeName("-");
        }else if(StringUtils.isEmpty(userIntegralInfo.getChangeSituation())){
            userIntegralInfo.setChangeSituation("-");
        }
        mmap.put("userIntegralInfo", userIntegralInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存积分规则
     */
    @Log(title = "积分规则", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserIntegralInfo userIntegralInfo)
    {
        return toAjax(userIntegralInfoService.updateUserIntegralInfo(userIntegralInfo));
    }

    /**
     * 删除积分规则
     */
    @Log(title = "积分规则", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(UserIntegralInfo userIntegralInfo)
    {
        return toAjax(userIntegralInfoService.deleteUserIntegralInfoById(userIntegralInfo.getIntegralId()));
    }
}
