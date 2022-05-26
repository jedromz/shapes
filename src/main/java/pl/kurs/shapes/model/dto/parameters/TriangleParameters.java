package pl.kurs.shapes.model.dto.parameters;

import lombok.*;
import pl.kurs.shapes.validation.annotation.Triangle;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TriangleParameters {
    private Double sideA;
    private Double sideB;
    private Double sideC;
}
