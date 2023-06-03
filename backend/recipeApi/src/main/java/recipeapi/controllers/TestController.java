package recipeapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipeapi.daos.TestDao;

@RestController
@RequestMapping(path = "/test/")
public class TestController {

    @Autowired
    private TestDao testDao;

    @GetMapping("{testId}")
    public String testGet(@PathVariable int testId) {
        return testDao.getRecipe(testId).getName();
    }
}
