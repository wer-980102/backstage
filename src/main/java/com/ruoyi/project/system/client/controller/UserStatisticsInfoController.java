package com.ruoyi.project.system.client.controller;

import java.util.List;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.TimeUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.client.domain.ClerkSaleInfo;
import com.ruoyi.project.system.client.domain.UserIntegralInfo;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.UserIntegralInfoDto;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.domain.param.TimeInfoParam;
import com.ruoyi.project.system.client.service.IClerkSaleInfoService;
import com.ruoyi.project.system.client.service.IUserIntegralInfoService;
import com.ruoyi.project.system.client.service.IUserStatisticsInfoService;
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
 * 门店数据Controller
 *
 * @author ruoyi
 * @date 2021-04-16
 */
@Controller
@RequestMapping("/system/client")
public class UserStatisticsInfoController extends BaseController
{
    private String prefix = "system/client";

    @Autowired
    private IUserStatisticsInfoService userStatisticsInfoService;
    @Autowired
    private IClerkSaleInfoService iClerkSaleInfoService;
    @Autowired
    private IUserIntegralInfoService   iUserIntegralInfoService;

    @GetMapping()
    public String info()
    {
        return prefix + "/client";
    }

    /**
     * 查询门店数据列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserStatisticsInfo userStatisticsInfo)
    {
        startPage();
        List<UserStatisticsInfoDto> list = null;
        //管理员查全部
        if(CommonUtils.USER_ADMIN.equals(ShiroUtils.getLoginName())){
            list = userStatisticsInfoService.selectUserStatisticsInfoList(userStatisticsInfo);
        }else{
            userStatisticsInfo.setUserId(ShiroUtils.getUserId());
            list = userStatisticsInfoService.selectUserStatisticsInfoList(userStatisticsInfo);

        }
        return getDataTable(list);
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<UserStatisticsInfo> util = new ExcelUtil<UserStatisticsInfo>(UserStatisticsInfo.class);
        return util.importTemplateExcel("后台数据");
    }

    /**
     * 导出门店数据列表
     */
    @Log(title = "门店数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserStatisticsInfo userStatisticsInfo)
    {
        List<UserStatisticsInfoDto> list = userStatisticsInfoService.selectUserStatisticsInfoList(userStatisticsInfo);
        ExcelUtil<UserStatisticsInfoDto> util = new ExcelUtil<UserStatisticsInfoDto>(UserStatisticsInfoDto.class);
        return util.exportExcel(list, "门店数据数据");
    }

    @Log(title = "用户管理导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<UserStatisticsInfo> util = new ExcelUtil<UserStatisticsInfo>(UserStatisticsInfo.class);
        List<UserStatisticsInfo> userList = util.importExcel(file.getInputStream());
        String message = userStatisticsInfoService.importUser(userList, updateSupport);
        return AjaxResult.success(message);
    }
    /**
     * 新增门店数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存门店数据
     */
    @Log(title = "门店数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserStatisticsInfo userStatisticsInfo)
    {
        return toAjax(userStatisticsInfoService.insertUserStatisticsInfo(userStatisticsInfo));
    }

    /**
     * 详情
     */
    @GetMapping("/edit/{statisticsId}")
    public String edit(@PathVariable("statisticsId") Long statisticsId, ModelMap mmap)
    {
        UserStatisticsInfoDto userStatisticsInfo = userStatisticsInfoService.selectUserStatisticsInfoById(statisticsId);
        mmap.put("userStatisticsInfo", userStatisticsInfo);
        return prefix + "/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detai/{statisticsId}")
    public String detai(@PathVariable("statisticsId") Long statisticsId, ModelMap mmap)
    {
        UserStatisticsInfoDto userStatisticsInfo = userStatisticsInfoService.selectUserStatisticsInfoById(statisticsId);
        mmap.put("userStatisticsInfo", userStatisticsInfo);
        return prefix + "/detai";
    }

    /**
     *  客户下销售纪录明细
     * @param userStatisticsInfo
     * @return
     */
    @PostMapping({"/userList"})
    @ResponseBody
    public TableDataInfo userList(UserStatisticsInfo userStatisticsInfo)
    {
        startPage();
        List<ClerkSaleInfo> list = this.iClerkSaleInfoService.getUserClerkSaleInfo(userStatisticsInfo.getStatisticsId().toString());
        return getDataTable(list);
    }

    /**
     * 升级用户
     */
    @ResponseBody
    @Log(title = "用户升级", businessType = BusinessType.UPDATE)
    @PostMapping("/specialUserEdit")
    public AjaxResult specialUserEdit(UserStatisticsInfo userStatisticsInfo)
    {
        String specialUserById = userStatisticsInfoService.getSpecialUserById(userStatisticsInfo.getStatisticsId());
        if(CommonUtils.SPECIAL_USER.equals(specialUserById)){
            return error("升级用户'" + userStatisticsInfo.getName() + "'失败，该用户已是特殊用户");
        }
        userStatisticsInfo.setSpecialUser(CommonUtils.SPECIAL_USER);
        return toAjax(userStatisticsInfoService.updateSpecialUserInfo(userStatisticsInfo));
    }

    /**
     * 一键减分
     */
    @ResponseBody
    @Log(title = "一键减分", businessType = BusinessType.UPDATE)
    @PostMapping("/scoreReduction")
    public AjaxResult ScoreReduction()
    {
        int i= 0;
        List<UserIntegralInfoDto> inactiveUserInfo = iClerkSaleInfoService.getInactiveUserInfo(TimeInfoParam.builder().startTime(TimeUtils.getMonthMinTime()).endTime(TimeUtils.getMonthMaxTime()).build());
       if(null != inactiveUserInfo){
           for (UserIntegralInfoDto dto : inactiveUserInfo){
               if(dto.getIntegral()>0){
                   i = iUserIntegralInfoService.updateUserIntegralInfo(UserIntegralInfo.builder().customerId(dto.getCustomerId()).integral(dto.getIntegral() - 1).build());
               }

           }
       }
        return toAjax(i);
    }
    /**
     * 修改保存门店数据
     */
    @Log(title = "门店数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserStatisticsInfo userStatisticsInfo)
    {
        String specialUserById = userStatisticsInfoService.getSpecialUserById(userStatisticsInfo.getStatisticsId());
        if(CommonUtils.SPECIAL_USER.equals(specialUserById)){
            return error("修改用户'" + userStatisticsInfo.getName() + "'失败，该用户是特殊用户");
        }
        return toAjax(userStatisticsInfoService.updateUserStatisticsInfo(userStatisticsInfo));
    }

    /**
     * 删除门店数据
     */
    @Log(title = "门店数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userStatisticsInfoService.deleteUserStatisticsInfoByIds(ids));
    }
}
