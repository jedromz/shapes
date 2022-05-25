package pl.kurs.shapes.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.kurs.shapes.model.dto.parameters.TriangleParameters;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RectangleDto extends ShapeDto{

    @JsonProperty("parameters")
    private RectangleParameters rectangleParameters;

    @Builder
    public RectangleDto(String type, Instant createdAt, Instant updatedAt, Double area, Double perimeter, RectangleParameters rectangleParameters) {
        super(type, createdAt, updatedAt, area, perimeter);
        this.rectangleParameters = rectangleParameters;
    }

}
