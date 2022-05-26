package pl.kurs.shapes.model.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchCriteriaCommand {
    @NotNull(message = "TYPE_NOT_NULL")
    private String type;
    @JsonProperty("parameters")
    private SearchParameters searchParameters;
}
