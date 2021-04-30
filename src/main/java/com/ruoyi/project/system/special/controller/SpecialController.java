package com.ruoyi.project.system.special.controller;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.service.IUserStatisticsInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息
 *
 * @author wer
 */
@Controller
@RequestMapping("/system/special")
public class SpecialController extends BaseController
{
    private String prefix = "system/special";

    @Autowired
    private IUserStatisticsInfoService iUserStatisticsInfoService;


    @GetMapping()
    public String user()
    {
        return prefix + "/special";
    }

    /**
     * 查询特殊用户
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserStatisticsInfo userStatisticsInfo)
    {
        startPage();
        List<UserStatisticsInfoDto> list = iUserStatisticsInfoService.getSpecialUserInfo(userStatisticsInfo);
        return getDataTable(list);
    }
    /**
     * 详情
     */
    @GetMapping("/edit/{statisticsId}")
    public String edit(@PathVariable("statisticsId") Long statisticsId, ModelMap mmap)
    {
        UserStatisticsInfoDto userStatisticsInfo = iUserStatisticsInfoService.getSpecialUserByIdInfo(statisticsId);
        mmap.put("userStatisticsInfo", userStatisticsInfo);
        return prefix + "/edit";
    }
    /**
     * 用户降级
     */
    @ResponseBody
    @Log(title = "用户降级", businessType = BusinessType.UPDATE)
    @PostMapping("/specialUserEdit")
    public AjaxResult specialUserEdit(UserStatisticsInfo userStatisticsInfo)
    {
        userStatisticsInfo.setSpecialUser(CommonUtils.NORMAL_USER);
        return toAjax(iUserStatisticsInfoService.updateUserStatisticsSpecialUser(userStatisticsInfo));
    }

    /**
     * 修改保存特殊用户数据
     */
    @Log(title = "修改特殊用户数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserStatisticsInfo userStatisticsInfo)
    {
        return toAjax(iUserStatisticsInfoService.updateUserStatisticsInfo(userStatisticsInfo));
    }
}
