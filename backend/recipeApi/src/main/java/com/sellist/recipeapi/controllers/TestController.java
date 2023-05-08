package com.sellist.recipeapi.controllers;

import com.sellist.recipeapi.daos.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestDao testDao;

    @GetMapping(path = "/test")
    public String testGet() {
        return testDao.getRecipe().getName();
    }
}
