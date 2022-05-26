package pl.kurs.shapes.mappings.impl.command;

import org.springframework.stereotype.Service;
import pl.kurs.shapes.error.MissingParameterException;
import pl.kurs.shapes.mappings.IShapeMapper;
import pl.kurs.shapes.model.Circle;
import pl.kurs.shapes.model.Rectangle;
import pl.kurs.shapes.model.command.CreateShapeCommand;
import pl.kurs.shapes.model.command.ShapeParameters;

import java.util.Optional;

@Service
public class CreateShapeToRectangleMapper implements IShapeMapper<CreateShapeCommand, Rectangle> {
    @Override
    public String type() {
        return "rectangle";
    }

    @Override
    public Rectangle map(CreateShapeCommand source) throws MissingParameterException {
        Double base = checkParam(source.getParameters().getBase(), "base");
        Double height = checkParam(source.getParameters().getBase(), "height");
        return Rectangle.builder().base(base).height(height).build();
    }

    private Double checkParam(Double param, String paramName) throws MissingParameterException {
        return Optional.ofNullable(param).orElseThrow(() -> new MissingParameterException(paramName));
    }
}
