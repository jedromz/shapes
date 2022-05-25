package pl.kurs.shapes.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.kurs.shapes.model.dto.parameters.TriangleParameters;

import java.time.Instant;

@Getter
@Setter
public class TriangleDto extends ShapeDto {
    @JsonProperty("parameters")
    private TriangleParameters triangleParameters;

    @Builder
    public TriangleDto(String type, Instant createdAt, Instant updatedAt, Double area, Double perimeter, TriangleParameters triangleParameters) {
        super(type, createdAt, updatedAt, area, perimeter);
        this.triangleParameters = triangleParameters;
    }
}
