package net.mmal.controller;

import net.mmal.entity.User;
import net.mmal.service.UserService;
import net.mmal.utils.Constants;
import net.mmal.utils.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册用户管理
 * @author hanyi
 * @date 2017年04月08日
 */
@RestController
@RequestMapping("user")
public class UserController extends AbstractController{
    @Autowired
    private UserService userService;

    /**
     *新增注册用户
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(User user){
        String message = getVerifyMessage(user);
        if (!message.equals(Constants.SUCCESS)){
            return R.error(message);
        }
        userService.save(user);
        return R.ok();
    }

    /**
     *修改注册用户
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(User user){
        String message = getVerifyMessage(user);
        if (!message.equals(Constants.SUCCESS)){
            return R.error(message);
        }
        userService.update(user);
        return R.ok();
    }

    /**
     *获得验证信息
     */
    private String getVerifyMessage(User user){
        if (user == null){
            return "用户不能为空";
        }
        if (StringUtils.isBlank(user.getAccount())){
            return "账号不能为空";
        }
        if (StringUtils.isBlank(user.getPassword())){
            return "密码不能为空";
        }
        return Constants.SUCCESS;
    }


}
