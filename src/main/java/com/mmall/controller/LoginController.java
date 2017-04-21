package com.mmall.controller;

import com.mmall.utils.Md5Utils;
import com.mmall.utils.R;
import com.mmall.utils.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登陆相关api
 *
 * @author hanyi1
 * @date 2017年04月08日
 */
@RestController
@RequestMapping("/u/")
public class LoginController extends AbstractController {
    /**
     * 登陆
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public R login(String account, String password) {
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return R.error("帐号密码不能为空");
        }
        try {
            Subject subject = ShiroUtils.getSubject();
            password = Md5Utils.getMd5String(password);
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
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

    /**
     * 退出登陆
     */
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public R logout() {
        ShiroUtils.logout();
        return R.ok();
    }

    /**
     * 判断是否登陆
     */
    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    public R checkLogin() {
        if (ShiroUtils.isLogin()) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}
