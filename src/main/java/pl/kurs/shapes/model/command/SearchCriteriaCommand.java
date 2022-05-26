package pl.kurs.shapes.model.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaCommand {
    @NotNull(message = "TYPE_NOT_NULL")
    private String type;
    @JsonProperty("parameters")
    private SearchParameters searchParameters;
}
