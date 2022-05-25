package pl.kurs.shapes.mappings;

import pl.kurs.shapes.model.command.ShapeParameters;

public interface IShapeCommand {
    String getType();
    ShapeParameters getParameters();
}
