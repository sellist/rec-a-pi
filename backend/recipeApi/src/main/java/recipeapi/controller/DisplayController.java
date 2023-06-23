package recipeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipeapi.models.recipe.Recipe;
import recipeapi.service.RecipeServiceImpl;

@RestController
@RequestMapping("/display")
public class DisplayController {

    @Autowired
    private RecipeServiceImpl recipeServiceImpl;

    @Cacheable
    @GetMapping()
    public ResponseEntity<Recipe> getActiveRecipe() {
        Recipe foundRecipe = recipeServiceImpl.getActive();
        if (foundRecipe == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundRecipe);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateActiveRecipe(@PathVariable Long id) {
        if (id < 1) {
            return ResponseEntity.notFound().build();
        } else {
            Recipe returnVal = recipeServiceImpl.updateActive(id);
            return ResponseEntity.ok(returnVal);
        }
    }
}
