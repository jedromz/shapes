package pl.kurs.shapes.mappings.impl.command;

import org.springframework.stereotype.Service;
import pl.kurs.shapes.mappings.IShapeMapper;
import pl.kurs.shapes.model.Circle;
import pl.kurs.shapes.model.Rectangle;
import pl.kurs.shapes.model.command.CreateShapeCommand;
import pl.kurs.shapes.model.command.ShapeParameters;

@Service
public class CreateShapeToRectangleMapper implements IShapeMapper<CreateShapeCommand, Rectangle> {
    @Override
    public String type() {
        return "rectangle";
    }

    @Override
    public Rectangle map(CreateShapeCommand source) {
        ShapeParameters parameters = source.getParameters();
        return Rectangle.builder()
                .base(parameters.getBase())
                .height(parameters.getHeight())
                .build();
    }
}
