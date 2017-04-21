package net.mmall.service.impl;

import net.mmall.dao.PersonDao;
import net.mmall.entity.Person;
import net.mmall.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hanyi
 * @date 2017年04月12日
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;
    @Override
    public Person getById(Integer id) {
        return personDao.queryById(id);
    }

    @Override
    public Person getByUserId(Integer userId) {
        return personDao.queryByUserId(userId);
    }

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public void update(Person person) {
        personDao.update(person);
    }
}
