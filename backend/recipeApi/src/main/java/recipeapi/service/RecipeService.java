package recipeapi.service;

import recipeapi.models.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getAllRecipe();

    List<Recipe> getRecipeByTypeString(String request);

    Recipe createRecipe(Recipe recipe);

    void deleteRecipe(Long id);

    Recipe getRecipeById(Long id);
}
