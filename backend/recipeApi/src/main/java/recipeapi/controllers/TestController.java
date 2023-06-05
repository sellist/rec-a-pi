package recipeapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipeapi.daos.RecipeDao;
import recipeapi.models.Recipe;

@RestController
@RequestMapping(path = "/recipes/")
public class TestController {

    @Autowired
    private RecipeDao recipeDao;

    @GetMapping("test/{testId}")
    public String testGet(@PathVariable int testId) {
        return recipeDao.getRecipe(testId).getName();
    }

    @GetMapping("{recipeId}")
    public Recipe getRecipe(@PathVariable int recipeId) {
        return recipeDao.getRecipe(recipeId);
    }
}
