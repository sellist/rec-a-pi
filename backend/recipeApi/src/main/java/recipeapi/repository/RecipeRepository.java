package recipeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import recipeapi.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Transactional
    @Modifying
    @Query("""
            update Recipe r set r.name = ?1, r.type = ?2, r.ingredients = ?3, r.time = ?4, r.instructions = ?5
            where r.id = ?6""")
    int updateRecipeById(String name, String type, String ingredients, int time, String instructions, @NonNull int id);


}
