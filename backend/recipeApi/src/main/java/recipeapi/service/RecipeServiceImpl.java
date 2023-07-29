package recipeapi.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;
import recipeapi.models.recipe.Recipe;
import recipeapi.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements AbstractService<Recipe, Long> {

    @Autowired
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        super();
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipeByTypeString(String[] request) {
        Set<String> s = new HashSet<>(Arrays.stream(request).toList());
        List<Recipe> recipes = this.getAll();
        List<Recipe> output = new ArrayList<>();

        for (Recipe r : recipes) {
            if (r.getType().containsAll(s)) {
                output.add(r);
            }
        }

        return output;
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

    public Recipe getActive() {
        return this.recipeRepository.findByActiveTrue();
    }

    public Recipe updateActive(Long toActivateId) {
        if (toActivateId < 1 || toActivateId > getRowCount()) {
            throw new ResourceAccessException("Not a valid ID");
        }

        Recipe activeRecipe = this.getActive();

        if (activeRecipe == null) {
            Recipe recipeToActivate = this.get(toActivateId);
            recipeToActivate.setActive(true);
            return recipeRepository.save(recipeToActivate);
        }

        activeRecipe.setActive(null);
        recipeRepository.saveAndFlush(activeRecipe);

        Recipe recipeToActivate = this.get(toActivateId);
        recipeToActivate.setActive(true);
        return recipeRepository.save(recipeToActivate);
    }

    @PostConstruct
    public void defaultAcitve(){
        this.updateActive(1L);
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

    private long getRowCount() {
        return recipeRepository.count();
    }
}
