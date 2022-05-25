package pl.kurs.shapes.model.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaCommand {
    private String type;
    @JsonProperty("parameters")
    private SearchParameters searchParameters;
}
