package recipeapi.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import recipeapi.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Transactional
    @Query(value = "select * from recipe where id = :id", nativeQuery = true)
    Recipe getRecipe(@Param("id") long id);
}
