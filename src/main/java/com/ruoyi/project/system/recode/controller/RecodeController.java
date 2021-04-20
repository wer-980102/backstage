package com.ruoyi.project.system.recode.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.service.IUserStatisticsInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户信息
 *
 * @author wer
 */
@Controller
@RequestMapping("/system/recode")
public class RecodeController extends BaseController
{
    private String prefix = "system/recode";

    @Autowired
    private IUserStatisticsInfoService iUserStatisticsInfoService;

    @RequiresPermissions("system:recode:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/recode";
    }


    /**
     * 查询销售纪录管理
     */
    @RequiresPermissions("system:recode:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserStatisticsInfo userStatisticsInfo)
    {
        startPage();
        List<UserStatisticsInfoDto> list = iUserStatisticsInfoService.getSaleRecordInfo(userStatisticsInfo);
        return getDataTable(list);
    }
}
