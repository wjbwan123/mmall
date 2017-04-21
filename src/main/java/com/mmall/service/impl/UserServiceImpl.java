package com.mmall.service.impl;

import com.mmall.dao.UserDao;
import com.mmall.entity.User;
import com.mmall.service.UserService;
import com.mmall.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 注册用户管理
 * @author hanyi
 * @date 2017年04月08日
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User getByAccount(String account) {
        return userDao.queryByAccount(account);
    }

    @Override
    public void save(User user) {
        Date now = new Date();
        user.setCreateTime(now);
        user.setLastLoginTime(now);
        user.setSystemIntegral(Constants.REGISTER_INTEGRAL);
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
