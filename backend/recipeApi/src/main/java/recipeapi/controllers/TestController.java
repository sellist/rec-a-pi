package recipeapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import recipeapi.daos.TestDao;

@RestController
public class TestController {

    @Autowired
    private TestDao testDao;

    @GetMapping(path = "/test")
    public String testGet(@PathVariable int id) {
        return testDao.getRecipe(id).getName();
    }
}
