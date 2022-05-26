package pl.kurs.shapes.mappings.impl.command;

import org.springframework.stereotype.Service;
import pl.kurs.shapes.error.MissingParameterException;
import pl.kurs.shapes.mappings.IShapeMapper;
import pl.kurs.shapes.model.Circle;
import pl.kurs.shapes.model.command.CreateShapeCommand;
import pl.kurs.shapes.model.command.ShapeParameters;

import java.util.Optional;

@Service
public class CreateShapeToCircleMapper implements IShapeMapper<CreateShapeCommand, Circle> {
    @Override
    public String type() {
        return "circle";
    }

    @Override
    public Circle map(CreateShapeCommand command) throws MissingParameterException {
        ShapeParameters parameters = command.getParameters();
        Double radius = checkParam(parameters.getRadius(), "radius");
        return new Circle(radius);
    }

    private Double checkParam(Double param, String paramName) throws MissingParameterException {
        return Optional.ofNullable(param)
                .orElseThrow(() -> new MissingParameterException(paramName));
    }

}
