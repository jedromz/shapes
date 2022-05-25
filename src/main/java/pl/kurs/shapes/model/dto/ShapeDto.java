package pl.kurs.shapes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ShapeDto {
    String type;
    Instant createdAt;
    Instant updatedAt;
    Double area;
    Double perimeter;
}
