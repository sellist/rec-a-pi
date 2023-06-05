package recipeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
@EnableCaching
public class RecipeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeApiApplication.class, args);
    }

}
