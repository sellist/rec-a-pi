package recipeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import recipeapi.models.Recipe;
import recipeapi.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        super();
        this.recipeRepository = recipeRepository;
    }


    @Override
    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> getRecipeByTypeString(String request) {
        Pattern regex = Pattern.compile("(\\b[^\\s\\W]+\\b)");
        List<Recipe> allRecipe = getAllRecipe();
        Optional<Recipe> result = allRecipe.stream().filter(
                o -> regex.matcher(o.getType()).matches()).findAny();
        return result.stream().toList();
        // (\b[^\s\W]+\b)
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Recipe not found by id: " + id));

        recipeRepository.delete(recipe);
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Recipe result = recipeRepository.getRecipe(id);
        if(result != null) {
            return result;
        }else {
            throw new ResourceAccessException("Recipe not found by id: " + id);
        }
    }
}
