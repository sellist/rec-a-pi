package recipeapi.models.recipe;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

public class RecipeListConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        return String.join(";",strings);
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        return Arrays.stream(s.split(";")).toList();
    }
}
