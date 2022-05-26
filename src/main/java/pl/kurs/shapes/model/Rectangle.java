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
public class Rectangle extends Shape {
    @PositiveOrZero(message = "BASE_NON_NEGATIVE")
    @NotNull(message = "BASE_NOT_NULL")
    private Double base;
    @PositiveOrZero(message = "HEIGHT_NON_NEGATIVE")
    @NotNull
    @NotNull(message = "HEIGHT_NOT_NULL")
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
