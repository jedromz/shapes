package pl.kurs.shapes.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.kurs.shapes.model.dto.parameters.TriangleParameters;

import java.time.Instant;

@Getter
@Setter
public class TriangleDto extends ShapeDto {
    @JsonProperty("parameters")
    private TriangleParameters triangleParameters;

    @Builder
    public TriangleDto(Long id, String type, Instant createdAt, Instant updatedAt, Double area, Double perimeter, TriangleParameters triangleParameters) {
        super(id, type, createdAt, updatedAt, area, perimeter);
        this.triangleParameters = triangleParameters;
    }
}
