package recipeapi.models.refdata;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Converter
public class RefTagsConverter implements AttributeConverter<Set<String>, String> {

    @Autowired
    RefTagsService refTagsService;

    @Override
    public String convertToDatabaseColumn(Set<String> o) {
        StringBuilder outputString = new StringBuilder();
        for (String type : o) {
            if (refTagsService.validTag(type)) {
                outputString.append(type.toLowerCase());
                outputString.append(",");
            }
        }
        return outputString.toString();
    }

    @Override
    public Set<String> convertToEntityAttribute(String o) {
        String[] inputArray = o.split(",");
        return new HashSet<>(Arrays.asList(inputArray));
    }
}
