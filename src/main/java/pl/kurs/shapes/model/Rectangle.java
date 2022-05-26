package pl.kurs.shapes.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rectangle extends Shape {
    private Double base;
    private Double height;
    @Enumerated(value = EnumType.STRING)
    private ShapeType type = ShapeType.RECTANGLE;

    @Builder
    public Rectangle(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    public Double getBase() {
        return base;
    }

    public Double getHeight() {
        return height;
    }

    @Override
    public Double getArea() {
        return base * height;
    }

    @Override
    public Double getPerimeter() {
        return 2 * base + 2 * height;
    }
}
