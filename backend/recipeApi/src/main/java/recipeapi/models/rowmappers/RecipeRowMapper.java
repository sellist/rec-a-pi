package recipeapi.models.rowmappers;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import recipeapi.models.Recipe;

public class RecipeRowMapper {
    private RecipeRowMapper() {}

    public static Recipe mapToRecipe(SqlRowSet r) {
        Recipe recipe = new Recipe();
        recipe.setId(r.getInt("id"));
        recipe.setIngredients(r.getString("ingredients"));
        recipe.setName(r.getString("name"));
        recipe.setTime(r.getInt("time"));
        recipe.setType(r.getString("type"));
        recipe.setInstructions(r.getString("instructions"));

        return recipe;
    }
}
