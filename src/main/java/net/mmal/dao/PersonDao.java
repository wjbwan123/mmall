package net.mmal.dao;

import net.mmal.entity.Person;

/**
 * @author hanyi
 * @date 2017年04月12日
 */
public interface PersonDao extends BaseDao<Person> {
    Person queryByUserId(Integer userId);
}
