package com.sellist.recipeapi.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheService {

    @Autowired
    private CacheConfiguration typeCache;

    public boolean checkValidRecipe(String input) {
        return typeCache.typeCacheImpl().contains(input.toUpperCase());
    }
}
