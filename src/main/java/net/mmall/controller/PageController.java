package net.mmall.controller;

import net.mmall.service.RegionService;
import net.mmall.utils.Constants;
import net.mmall.utils.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面视图
 *
 * @author hanyi
 * @date 2017年04月08日
 */
@Controller
public class PageController extends AbstractController {
    @Autowired
    private RegionService regionService;

    /**
     * 首页视图
     */
    @RequestMapping("/")
    public String index() {
        //List<Region> list = regionService.getRegionTree();
        //request.setAttribute("list", list);
        return "index.html";
    }

    /**
     * 公共视图
     */
    @RequestMapping("{module}/{url}.html")
    public String commonPage(@PathVariable("module") String module, @PathVariable("url") String url) {
        if (StringUtils.isBlank(module) || StringUtils.isBlank(url)) {
            return "error/404.html";
        }
        if (module.equals(Constants.LOGIN_FILTER_PACKAGE) && !ShiroUtils.isLogin()) {
            //没有登陆跳到登陆页面
            return "login.html";
        }
        return module + "/" + url + ".html";
    }
}
