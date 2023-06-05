package recipeapi.models;

import lombok.Data;

@Data
public class Recipe {

    private int recipeId;
    private String name;
    private String type;
    private String ingredients;
    private int time;
    private String instructions;

}
