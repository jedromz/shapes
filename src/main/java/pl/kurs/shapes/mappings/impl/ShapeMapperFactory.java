package pl.kurs.shapes.mappings.impl;

import pl.kurs.shapes.error.MissingParameterException;
import pl.kurs.shapes.mappings.IShapeCommand;
import pl.kurs.shapes.mappings.IShapeDtoMapper;
import pl.kurs.shapes.mappings.IShapeMapper;
import pl.kurs.shapes.model.Shape;
import pl.kurs.shapes.model.dto.ShapeDto;

import java.util.HashMap;
import java.util.Map;

public class ShapeMapperFactory {
    private final Map<String, IShapeMapper<IShapeCommand, Shape>> mappersMap = new HashMap<>();
    private final Map<Class<Shape>, IShapeDtoMapper<Shape, ShapeDto>> dtoMappersMap = new HashMap<>();

    public void addMapper(IShapeMapper<IShapeCommand, Shape> mapper) {
        mappersMap.put(mapper.type(), mapper);
    }

    public void addDtoMapper(IShapeDtoMapper<Shape, ShapeDto> mapper) {
        dtoMappersMap.put(mapper.type(), mapper);
    }

    public Shape map(IShapeCommand command) throws MissingParameterException {
        return mappersMap.get(command.getType()).map(command);
    }

    public ShapeDto mapToDto(Shape shape) {
        return dtoMappersMap.get(shape.getClass()).map(shape);
    }
}
