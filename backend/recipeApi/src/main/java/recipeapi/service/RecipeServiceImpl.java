package recipeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;
import recipeapi.models.recipe.Recipe;
import recipeapi.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class RecipeServiceImpl implements AbstractService<Recipe, Long> {

    @Autowired
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        super();
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipeByTypeString(String request) {
        List<Recipe> allRecipe = this.getAll();
        Stream<Recipe> result = allRecipe.stream().filter(
                o -> o.getType().contains(request));
        return result.toList();
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
                dto.getId(),
                dto.getName(),
                dto.getType(),
                dto.getIngredients(),
                dto.getTime(),
                dto.getInstructions()

        );
    }

    @Transactional
    @Override
    public int updateObject(Recipe dto, Integer id) {
        if (id == null) {
            return updateObject(dto);
        } else {
            dto.setId(id);
        }
        return this.updateObject(dto);
    }
}
