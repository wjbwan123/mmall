package net.mmall.dao;

import net.mmall.entity.Person;

/**
 * @author hanyi
 * @date 2017年04月12日
 */
public interface PersonDao extends BaseDao<Person> {
    Person queryByUserId(Integer userId);
}
