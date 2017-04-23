package com.mmall.service;

import com.mmall.entity.User;

/**
 * 注册用户
 *
 * @author hanyi
 * @date 2017年04月08日
 */
public interface UserService {
    User getByUsername(String username);

    void save(User user);

    void update(User user);
}
