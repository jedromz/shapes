package pl.kurs.shapes.mappings.impl.command;

import org.springframework.stereotype.Service;
import pl.kurs.shapes.mappings.IShapeMapper;
import pl.kurs.shapes.model.Circle;
import pl.kurs.shapes.model.command.CreateShapeCommand;
import pl.kurs.shapes.model.command.ShapeParameters;

@Service
public class CreateShapeToCircleMapper implements IShapeMapper<CreateShapeCommand, Circle> {
    @Override
    public String type() {
        return "circle";
    }

    @Override
    public Circle map(CreateShapeCommand command) {
        ShapeParameters parameters = command.getParameters();
        return new Circle(parameters.getRadius());
    }

}
