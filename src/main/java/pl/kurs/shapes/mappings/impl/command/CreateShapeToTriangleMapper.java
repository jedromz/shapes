package pl.kurs.shapes.mappings.impl.command;

import org.springframework.stereotype.Service;
import pl.kurs.shapes.error.MissingParameterException;
import pl.kurs.shapes.mappings.IShapeMapper;
import pl.kurs.shapes.model.Triangle;
import pl.kurs.shapes.model.command.CreateShapeCommand;
import pl.kurs.shapes.model.command.ShapeParameters;

import java.util.Optional;

@Service
public class CreateShapeToTriangleMapper implements IShapeMapper<CreateShapeCommand, Triangle> {
    @Override
    public String type() {
        return "triangle";
    }

    @Override
    public Triangle map(CreateShapeCommand command) throws MissingParameterException {
        //modelMapper.map(command.getParameters(),Triangle.class) tez dziala bez customowego Convertera
        ShapeParameters parameters = command.getParameters();
        Double sideA = checkParam(parameters.getSideA(), "sideA");
        Double sideB = checkParam(parameters.getSideB(), "sideB");
        Double sideC = checkParam(parameters.getSideC(), "sideC");
        return Triangle.builder()
                .sideA(sideA)
                .sideB(sideB)
                .sideC(sideC)
                .build();
    }

    private Double checkParam(Double param, String paramName) throws MissingParameterException {
        return Optional.ofNullable(param).orElseThrow(() -> new MissingParameterException(paramName));
    }
}
