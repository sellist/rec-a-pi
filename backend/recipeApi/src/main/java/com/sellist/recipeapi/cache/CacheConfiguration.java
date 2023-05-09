package com.sellist.recipeapi.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class CacheConfiguration {

    @Bean
    public Set<String> typeCacheImpl() {
        Set<RecipeTypes> rs = Collections.unmodifiableSet(EnumSet.allOf(RecipeTypes.class));
        return rs.stream().map(Enum::name).collect(Collectors.toSet());
    }

}
