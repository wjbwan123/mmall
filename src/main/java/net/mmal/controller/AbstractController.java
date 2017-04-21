package net.mmal.controller;

import net.mmal.entity.User;
import net.mmal.utils.ShiroUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 * 
 * @author hanyi
 * @date 2017年03月01日
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected User getUser() {
		return ShiroUtils.getUser();
	}

	protected Integer getUserId() {
		return getUser().getId();
	}

	protected Session getSession() {
		return ShiroUtils.getSession();
	}
}
