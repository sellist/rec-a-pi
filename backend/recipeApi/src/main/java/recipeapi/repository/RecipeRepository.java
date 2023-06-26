package recipeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import recipeapi.models.recipe.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findByActiveTrue();

    @Transactional
    @Modifying
    @Query("""
            update Recipe r set r.name = ?2, r.type = ?3, r.ingredients = ?4, r.time = ?5, r.instructions = ?6
            where r.id = ?1""")
    int updateRecipeById(@NonNull int id,
                         @NonNull String name,
                         @NonNull Set<String> type,
                         @NonNull List<String> ingredients,
                         @NonNull int time,
                         @NonNull List<String> instructions);
}
