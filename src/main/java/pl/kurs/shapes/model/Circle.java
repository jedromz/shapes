package pl.kurs.shapes.model;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class Circle extends Shape {

    @PositiveOrZero(message = "RADIUS_NON_NEGATIVE")
    @NotNull(message = "RADIUS_NOT_NULL")
    private Double radius;
    @Enumerated(value = EnumType.STRING)
    private ShapeType type = ShapeType.CIRCLE;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Double getArea() {
        return Math.PI * radius * radius;
    }

    public Double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
