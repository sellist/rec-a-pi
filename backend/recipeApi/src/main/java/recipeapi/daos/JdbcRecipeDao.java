package recipeapi.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import recipeapi.models.Recipe;
import recipeapi.models.rowmappers.RecipeRowMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecipeDao implements RecipeDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public JdbcRecipeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Cacheable("recipes")
    public Recipe getRecipe(int testId) {
        Recipe r = null;
        String sql = "SELECT * FROM recipe WHERE recipe_id = ? ;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,testId);
        if (results.next()) {
            r = RecipeRowMapper.mapToRecipe(results);
        }

        return r;
    }

    public List<Recipe> searchForTypes(String input) {

        return new ArrayList<>();

    }
}
