package pl.kurs.shapes.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RectangleParameters {
    private Double base;
    private Double height;
}
