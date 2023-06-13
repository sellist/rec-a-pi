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
    public String convertToDatabaseColumn(Set<String> inputSet) {
        StringBuilder outputString = new StringBuilder();
        for (String type : inputSet) {
            if (refTagsService.validTag(type)) {
                outputString.append(type.toLowerCase());
                outputString.append(",");
            }
        }
        return outputString.toString();
    }

    @Override
    public Set<String> convertToEntityAttribute(String inputString) {
        String[] inputArray = inputString.split(",");
        return new HashSet<>(Arrays.asList(inputArray));
    }
}
