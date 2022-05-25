package pl.kurs.shapes.model.dto.parameters;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TriangleParameters {
    private Double base;
    private Double height;
}
