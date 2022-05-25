package pl.kurs.shapes.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Triangle extends Shape {
    private Double base;
    private Double height;

    public Double getArea() {
        return height * base / 2;
    }

    public Double getPerimeter() {
        return base + base + base;
    }


}
