package com.ruoyi.project.system.recode.controller;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.service.IClerkSaleInfoService;
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
@RequestMapping("/system/recode")
public class RecodeController extends BaseController
{
    private String prefix = "system/recode";

    @Autowired
    private IUserStatisticsInfoService iUserStatisticsInfoService;

    @Autowired
    private IClerkSaleInfoService clerkSaleInfoService;

    @GetMapping()
    public String user()
    {
        return prefix + "/recode";
    }


    /**
     * 查询销售纪录管理
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserStatisticsInfo userStatisticsInfo)
    {
        startPage();
        List<UserStatisticsInfoDto> list = null;
        //管理员查全部
        if(CommonUtils.USER_ADMIN.equals(ShiroUtils.getLoginName())){
            list = iUserStatisticsInfoService.getSaleRecordInfo(userStatisticsInfo);
        }else{
            userStatisticsInfo.setUserId(ShiroUtils.getUserId());
            list = iUserStatisticsInfoService.getSaleRecordInfo(userStatisticsInfo);

        }
        return getDataTable(list);
    }

    /**
     * 详情
     */
    @GetMapping("/edit/{saleId}")
    public String edit(@PathVariable("saleId") Long saleId, ModelMap mmap)
    {
        UserStatisticsInfoDto userStatisticsInfo = iUserStatisticsInfoService.getSaleRecordById(saleId);
        mmap.put("userStatisticsInfo", userStatisticsInfo);
        return prefix + "/edit";
    }

    /**
     * 修改销售纪录数据
     */
    @Log(title = "修改特殊用户数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserStatisticsInfo userStatisticsInfo)
    {
        return toAjax(clerkSaleInfoService.updateClerkSaleByIdInfo(userStatisticsInfo));
    }

    /**
     * 删除销售纪录
     */
    @Log(title = "删除销售纪录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(UserStatisticsInfo userStatisticsInfo)
    {
        return toAjax(clerkSaleInfoService.deleteClerkSaleInfoById(userStatisticsInfo.getSaleId()));
    }
}
