package net.mmal.controller;

import net.mmal.entity.Person;
import net.mmal.service.PersonService;
import net.mmal.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanyi
 * @date 2017年04月12日
 */
@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(Person person) {
        personService.save(person);
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(Person person) {
        personService.update(person);
        return R.ok();
    }
}
