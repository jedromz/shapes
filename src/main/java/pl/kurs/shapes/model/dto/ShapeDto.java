package pl.kurs.shapes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ShapeDto {
    private Long id;
    private String type;
    private Instant createdAt;
    private Instant updatedAt;
    private Double area;
    private Double perimeter;
}
