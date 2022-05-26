package pl.kurs.shapes.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Triangle extends Shape {
    @PositiveOrZero
    @NotNull(message = "SIDE_A_NOT_NULL")
    private Double sideA;
    @PositiveOrZero
    @NotNull(message = "SIDE_B_NOT_NULL")
    private Double sideB;
    @PositiveOrZero
    @NotNull(message = "SIDE_C_NOT_NULL")
    private Double sideC;
    @Enumerated(value = EnumType.STRING)
    private ShapeType type = ShapeType.TRIANGLE;

    @Builder
    public Triangle(Double sideA, Double sideB, Double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public Double getArea() {
        Double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public Double getPerimeter() {
        return sideA + sideB + sideC;
    }
}
