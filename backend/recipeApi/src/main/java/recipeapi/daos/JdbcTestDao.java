package recipeapi.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import recipeapi.models.Recipe;

@Component
public class JdbcTestDao implements TestDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public JdbcTestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Cacheable(cacheNames = "recipes")
    public Recipe getRecipe(int id) {
        Recipe r = null;
        String sql = "SELECT * FROM recipe WHERE id = ? LIMIT 1;";
        System.out.println("from method");

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        if (results.next()) {
            r = mapToRecipe(results);
        }

        return r;
    }

    private Recipe mapToRecipe(SqlRowSet r) {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(r.getInt("recipe_id"));
        recipe.setIngredients(r.getString("ingredients"));
        recipe.setName(r.getString("name"));
        recipe.setTime(r.getInt("time"));
        recipe.setType(r.getString("type"));
        recipe.setInstructions(r.getString("instructions"));

        return recipe;
    }
}
