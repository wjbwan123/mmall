package net.mmall.dao;

import net.mmall.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 注册用户管理1
 * @author hanyi
 * @date 2017年04月08日
 */
public interface UserDao extends BaseDao<User>{
     User queryByAccount(@Param("account") String account);
}
