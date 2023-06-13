package recipeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import recipeapi.models.Recipe;

import java.util.Set;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Transactional
    @Modifying
    @Query("""
            update Recipe r set r.name = ?2, r.type = ?3, r.ingredients = ?4, r.time = ?5, r.instructions = ?6
            where r.id = ?1""")
    int updateRecipeById(@NonNull int id,
                         @NonNull String name,
                         @NonNull Set<String> type,
                         @NonNull String ingredients,
                         @NonNull int time,
                         @NonNull String instructions);




}
