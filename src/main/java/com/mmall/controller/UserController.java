package com.mmall.controller;

import com.mmall.common.ResponseCode;
import com.mmall.common.Result;
import com.mmall.entity.User;
import com.mmall.service.UserService;
import com.mmall.utils.Constants;
import com.mmall.utils.Md5Utils;
import com.mmall.utils.R;
import com.mmall.utils.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanyi
 * @date 2017年04月23日
 */
@RestController
@RequestMapping("/user/")
public class UserController extends AbstractController {
    @Autowired
    private UserService userService;

    //注册
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public R register(User user) {
        R result = verifyUser(user);
        if (result.get("code") != ResponseCode.SUCCESS.getCode()) {
            return result;
        }
        userService.save(user);
        return R.ok();
    }

    //登陆
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public R login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return R.error("帐号密码不能为空");
        }
        try {
            Subject subject = ShiroUtils.getSubject();
            password = Md5Utils.getMd5String(password);
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error(e.getMessage());
        } catch (LockedAccountException e) {
            return R.error(e.getMessage());
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }
        return R.ok();
    }

    //退出
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public R logout() {
        ShiroUtils.logout();
        return R.ok();
    }

    //判断是否登陆
    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    public R checkLogin() {
        if (ShiroUtils.isLogin()) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //验证
    private R verifyUser(User user) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return R.error("帐号密码不能为空");
        }
        return R.ok();
    }
}

