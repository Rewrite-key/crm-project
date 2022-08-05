package crm.workbench.web.controller;

import crm.commons.contants.Contants;
import crm.commons.domain.ReturnObject;
import crm.commons.util.DataUtil;
import crm.commons.util.UUIDUtils;
import crm.settings.domain.User;
import crm.settings.service.UserService;
import crm.workbench.domain.Activity;
import crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request){
        List<User> users = userService.queryAllUsers();
        request.setAttribute("users",users);
        return "workbench/activity/index";
    }

    @RequestMapping("/workbench/activity/saveCreateActivity.do")
    @ResponseBody
    public Object saveCreateActivity(Activity activity , HttpSession session){
        User user = (User) session.getAttribute(Contants.SESSION.getValue());

        activity.setId(UUIDUtils.getUUID());
        activity.setCreateTime(DataUtil.formatDateTime(new Date()));
        activity.setCreateBy(user.getId());

        ReturnObject returnObject = new ReturnObject();
        try {
            int i = activityService.saveCreatActivity(activity);
            if (i>0){
                returnObject.setCode(Contants.CODE.getSuccess());
            }else {
                returnObject.setCode(Contants.CODE.getFail());
                returnObject.setMessage("请稍后重试。。。");
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnObject.setCode(Contants.CODE.getFail());
            returnObject.setMessage("请稍后重试。。。");
        }

        return returnObject;

    }
}
