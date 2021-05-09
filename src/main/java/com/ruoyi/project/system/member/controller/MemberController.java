package com.ruoyi.project.system.member.controller;

import com.ruoyi.common.utils.CommonUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.client.domain.UserStatisticsInfo;
import com.ruoyi.project.system.client.domain.dto.UserStatisticsInfoDto;
import com.ruoyi.project.system.client.service.IUserStatisticsInfoService;
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
@RequestMapping("/system/member")
public class MemberController extends BaseController
{
    private String prefix = "system/member";

    @Autowired
    private IUserStatisticsInfoService iUserStatisticsInfoService;
    @Autowired
    private IUserStatisticsInfoService userStatisticsInfoService;

    @GetMapping()
    public String user()
    {
        return prefix + "/member";
    }

    /**
     * 查询是否会员
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserStatisticsInfo userStatisticsInfo)
    {
        startPage();
        List<UserStatisticsInfoDto> list = null;
        //管理员查全部
        if(CommonUtils.USER_ADMIN.equals(ShiroUtils.getLoginName())){
            list = iUserStatisticsInfoService.getMemberUserInfo(userStatisticsInfo);
        }else{
            userStatisticsInfo.setUserId(ShiroUtils.getUserId());
            list = iUserStatisticsInfoService.getMemberUserInfo(userStatisticsInfo);

        }
        return getDataTable(list);
    }
    /**
     * 详情
     */
    @GetMapping("/edit/{statisticsId}")
    public String edit(@PathVariable("statisticsId") Long statisticsId, ModelMap mmap)
    {
        UserStatisticsInfoDto userStatisticsInfo = iUserStatisticsInfoService.getMemberUserByIdInfo(statisticsId);
        mmap.put("userStatisticsInfo", userStatisticsInfo);
        return prefix + "/edit";
    }

    /**
     * 修改会员状态
     */
    @Log(title = "修改会员状态", businessType = BusinessType.UPDATE)
    @PostMapping("/editUser")
    @ResponseBody
    public AjaxResult editUser(UserStatisticsInfo userStatisticsInfo)
    {
        return toAjax(userStatisticsInfoService.updateUserStatisticsMember(userStatisticsInfo));
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
     * 修改用户会员数据
     */
    @Log(title = "修改特殊用户数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserStatisticsInfo userStatisticsInfo)
    {
        return toAjax(iUserStatisticsInfoService.updateUserStatisticsInfo(userStatisticsInfo));
    }
}
