package recipeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipeapi.models.recipe.Recipe;
import recipeapi.models.refdata.RefTagsService;
import recipeapi.service.RecipeServiceImpl;

import java.util.List;
import java.util.Set;


@CrossOrigin
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeServiceImpl recipeServiceImpl;

    @Autowired
    private RefTagsService refTagsService;

    @Cacheable(value = "recipes")
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        Recipe foundRecipe = recipeServiceImpl.get(id);
        if (foundRecipe == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundRecipe);
        }
    }

    @GetMapping("/search/{types}")
    public ResponseEntity<List<Recipe>> searchRecipeByType(@PathVariable String[] types) {
        List<Recipe> returnedRecipes = this.recipeServiceImpl.getRecipeByTypeString(types);
        if (returnedRecipes == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(returnedRecipes);
        }
    }


    @GetMapping("/types")
    public ResponseEntity<Set<String>> getValidTags() {
        Set<String> tags = refTagsService.getRefTagsSet();
        if (tags == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tags);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> foundRecipes = recipeServiceImpl.getAll();
        if (foundRecipes == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundRecipes);
        }
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeServiceImpl.create(recipe);
        if (createdRecipe == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(createdRecipe);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateRecipe(@RequestBody Recipe updatedRecipe, @PathVariable int id) {
        if (updatedRecipe == null) {
            return ResponseEntity.notFound().build();
        } else {
            Integer returnVal = recipeServiceImpl.updateObject(updatedRecipe, id);
            return ResponseEntity.ok(returnVal);
        }
    }

}
