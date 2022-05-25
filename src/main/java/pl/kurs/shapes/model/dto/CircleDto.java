package pl.kurs.shapes.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.kurs.shapes.model.dto.parameters.CircleParameters;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CircleDto extends ShapeDto {
    @Builder
    public CircleDto(String type, Instant createdAt, Instant updatedAt, Double area, Double perimeter, CircleParameters circleParameters) {
        super(type, createdAt, updatedAt, area, perimeter);
        this.circleParameters = circleParameters;
    }

    @JsonProperty("parameters")
    private CircleParameters circleParameters;

}
