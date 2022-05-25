package pl.kurs.shapes.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Circle extends Shape {
    Double radius;

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public Double getArea() {
        return Math.PI * radius * radius;
    }

    public Double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
