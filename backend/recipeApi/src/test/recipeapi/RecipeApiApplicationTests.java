package recipeapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecipeApiApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertSame(2,1+1);
    }

}
