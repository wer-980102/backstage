package com.ruoyi.project.system.integral.controller;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.client.domain.UserIntegralInfo;
import com.ruoyi.project.system.client.service.IUserIntegralInfoService;
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
@RequestMapping("/system/integral")
public class IntegralController extends BaseController
{
    @Autowired
    private IUserIntegralInfoService userIntegralInfoService;

    private String prefix = "system/integral";


    @GetMapping()
    public String user()
    {
        return prefix + "/integral";
    }

    /**
     * 查询积分规则列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserIntegralInfo userIntegralInfo)
    {
        startPage();
        List<UserIntegralInfo> list = null;
        //管理员查全部
        if(CommonUtils.USER_ADMIN.equals(ShiroUtils.getLoginName())){
            list = userIntegralInfoService.selectUserIntegralInfoList(userIntegralInfo);
        }else{
            userIntegralInfo.setUserId(ShiroUtils.getUserId());
            list = userIntegralInfoService.selectUserIntegralInfoList(userIntegralInfo);

        }
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
     * 新增积分规则
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存积分规则
     */
    @Log(title = "积分规则", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserIntegralInfo userIntegralInfo)
    {
        int i = 0;
        List<UserIntegralInfo> userIntegralInfos = userIntegralInfoService.selectUserIntegralInfoList(UserIntegralInfo.builder().type(1).build());
        if(null != userIntegralInfos){
            for (UserIntegralInfo info : userIntegralInfos){
                userIntegralInfo.setCustomerId(info.getCustomerId());
                i = userIntegralInfoService.updateUserIntegralInfo(userIntegralInfo);
            }
        }
        return toAjax(i);
    }

    /**
     * 修改积分规则
     */
    @GetMapping("/edit/{integralId}")
    public String edit(@PathVariable("integralId") Long integralId, ModelMap mmap)
    {
        UserIntegralInfo userIntegralInfo = userIntegralInfoService.selectUserIntegralInfoById(integralId);
        if(StringUtils.isEmpty(userIntegralInfo.getIntegralRule())){
            userIntegralInfo.setIntegralRule("-");
        }else if(StringUtils.isEmpty(userIntegralInfo.getIntegralRemark())){
            userIntegralInfo.setIntegralRemark("-");
        }else if(StringUtils.isEmpty(userIntegralInfo.getOperator())){
            userIntegralInfo.setOperator("-");
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
     * 批量删除积分规则
     */
    @Log(title = "积分规则", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userIntegralInfoService.deleteUserIntegralInfoByIds(ids));
    }

    /**
     * 删除积分规则
     */
    @Log(title = "积分规则", businessType = BusinessType.DELETE)
    @PostMapping( "/deleteIntegral")
    @ResponseBody
    public AjaxResult deleteIntegral(UserIntegralInfo userIntegralInfo)
    {
        return toAjax(userIntegralInfoService.deleteUserIntegralInfoById(userIntegralInfo.getIntegralId()));
    }
}
