package com.sellist.recipeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

// Remove @EnableAutoConf to connect to DB
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class RecipeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApiApplication.class, args);
	}

}
