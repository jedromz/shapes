package pl.kurs.shapes.model.command;

import lombok.*;
import pl.kurs.shapes.validation.annotation.Triangle;

import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Triangle
public class ShapeParameters implements ITriangleParameters {
    @PositiveOrZero
    Double height;
    @PositiveOrZero
    Double base;
    @PositiveOrZero
    Double radius;
    @PositiveOrZero
    Double sideA;
    @PositiveOrZero
    Double sideB;
    @PositiveOrZero
    Double sideC;
}
