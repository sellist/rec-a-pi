package recipeapi.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import recipeapi.models.refdata.RefTagsConverter;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Nonnull
    private String name;

    @Column(name = "type")
    @Convert(converter = RefTagsConverter.class)
    private Set<String> type;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "time")
    private int time;

    @Column(name = "instructions")
    private String instructions;

}
