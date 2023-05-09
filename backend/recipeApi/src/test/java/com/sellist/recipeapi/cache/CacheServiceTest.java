package com.sellist.recipeapi.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CacheServiceTest {

    @Autowired
    CacheService cs;

    @Test
    void testServiceLoad() {
        Assertions.assertNotNull(cs);
    }

    @Test
    void typeCacheService() {
        Assertions.assertFalse(cs.checkValidRecipe("INVALID"));
        Assertions.assertTrue(cs.checkValidRecipe("SOUP"));
    }
}