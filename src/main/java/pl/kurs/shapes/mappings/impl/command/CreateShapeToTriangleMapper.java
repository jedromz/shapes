package pl.kurs.shapes.mappings.impl.command;

import org.springframework.stereotype.Service;
import pl.kurs.shapes.mappings.IShapeMapper;
import pl.kurs.shapes.model.Triangle;
import pl.kurs.shapes.model.command.CreateShapeCommand;
import pl.kurs.shapes.model.command.ShapeParameters;

@Service
public class CreateShapeToTriangleMapper implements IShapeMapper<CreateShapeCommand, Triangle> {
    @Override
    public String type() {
        return "triangle";
    }

    @Override
    public Triangle map(CreateShapeCommand command) {
        //modelMapper.map(command.getParameters(),Triangle.class) tez dziala bez customowego Convertera
        ShapeParameters parameters = command.getParameters();
        return Triangle.builder()
                .height(parameters.getHeight())
                .base(parameters.getBase())
                .build();
    }

}
