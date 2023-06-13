package recipeapi.models.refdata;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RefTagsService {

    private RefTags[] refTagsArray;

    private Set<String> refTagsSet;

    @PostConstruct
    private void setup(){
        this.refTagsArray = RefTags.values();
        this.refTagsSet = getTagsFromArray();
    }

    public boolean validTag(String input) {
        return refTagsSet.contains(input.toLowerCase());
    }


    private Set<String> getTagsFromArray() {
        Set<String> output = new HashSet<>();

        for (RefTags ref : refTagsArray) {
            output.add(ref.name().toLowerCase());
        }
        return output;
    }

    public Set<String> getRefTagsSet() {
        return refTagsSet;
    }
}
