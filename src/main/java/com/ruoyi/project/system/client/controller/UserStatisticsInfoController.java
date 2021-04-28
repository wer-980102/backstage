package com.ruoyi.project.system.client.controller;

import java.util.List;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
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
        List<UserStatisticsInfoDto> list = userStatisticsInfoService.selectUserStatisticsInfoList(userStatisticsInfo);
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
     * 升级用户
     */
    @ResponseBody
    @Log(title = "用户升级", businessType = BusinessType.UPDATE)
    @PostMapping("/specialUserEdit")
    public AjaxResult specialUserEdit(UserStatisticsInfo userStatisticsInfo)
    {
        String specialUserById = userStatisticsInfoService.getSpecialUserById(userStatisticsInfo.getStatisticsId());
        if(CommonUtils.SPECIAL_USER.equals(specialUserById)){
            return error("升级用户'" + userStatisticsInfo.getName() + "'失败，该用户是特殊用户");
        }
        userStatisticsInfo.setSpecialUser(CommonUtils.SPECIAL_USER);
        return toAjax(userStatisticsInfoService.updateSpecialUserInfo(userStatisticsInfo));
    }

    /**
     * 用户减分
     */
    @ResponseBody
    @Log(title = "用户减分", businessType = BusinessType.UPDATE)
    @PostMapping("/scoreReduction")
    public AjaxResult ScoreReduction(UserStatisticsInfo userStatisticsInfo)
    {
        String specialUserById = userStatisticsInfoService.getSpecialUserById(userStatisticsInfo.getStatisticsId());
        if(CommonUtils.SPECIAL_USER.equals(specialUserById)){
            return error("减分用户'" + userStatisticsInfo.getName() + "'失败，该用户是特殊用户");
        }
        userStatisticsInfo.setSpecialUser(CommonUtils.SPECIAL_USER);
        return toAjax(userStatisticsInfoService.updateUserStatisticsInfo(userStatisticsInfo));
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
        return toAjax(userStatisticsInfoService.updateClerkSaleByCustomerId(userStatisticsInfo));
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
