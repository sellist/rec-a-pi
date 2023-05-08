package com.sellist.recipeapi.daos;

import com.sellist.recipeapi.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcTestDao implements TestDao{

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public JdbcTestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Recipe getRecipe() {
        Recipe r = null;
        String sql = "SELECT * FROM recipe LIMIT 1;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            r = mapToRecipe(results);
        }

        return r;
    }

    private Recipe mapToRecipe(SqlRowSet r) {
        Recipe recipe = new Recipe();
        recipe.setRecipe_id(r.getInt("recipe_id"));
        recipe.setIngredients(r.getString("ingredients"));
        recipe.setName(r.getString("name"));
        recipe.setTime(r.getInt("time"));
        recipe.setType(r.getString("type"));
        recipe.setInstructions(r.getString("instructions"));

        return recipe;
    }
}
