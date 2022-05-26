package pl.kurs.shapes.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Circle extends Shape {

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
