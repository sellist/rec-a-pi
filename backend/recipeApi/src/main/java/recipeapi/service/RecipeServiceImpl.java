package recipeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;
import recipeapi.models.Recipe;
import recipeapi.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class RecipeServiceImpl implements AbstractService<Recipe, Long> {

    @Autowired
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        super();
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipeByTypeString(String request) {
        Pattern regex = Pattern.compile("(\\b[^\\s\\W]+\\b)");
        List<Recipe> allRecipe = this.getAll();
        Optional<Recipe> result = allRecipe.stream().filter(
                o -> regex.matcher(o.getType()).matches()).findAny();
        return result.stream().toList();
        // (\b[^\s\W]+\b)
    }

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe create(Recipe t) {
        return recipeRepository.save(t);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Recipe not found by id: " + id));

        recipeRepository.delete(recipe);
    }


    @Override
    public Recipe get(Long id) {
        Optional<Recipe> result = recipeRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceAccessException("Recipe not found by id: " + id);
        }
    }

    @Transactional
    @Override
    public int updateObject(Recipe dto) {

        if (dto.getId() == 0) {return 0;}

        return recipeRepository.updateRecipeById(
                dto.getName(),
                dto.getType(),
                dto.getIngredients(),
                dto.getTime(),
                dto.getInstructions(),
                dto.getId()
        );
    }
}
