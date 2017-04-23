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

}
