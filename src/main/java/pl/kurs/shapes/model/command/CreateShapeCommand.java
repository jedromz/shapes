package pl.kurs.shapes.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kurs.shapes.mappings.IShapeCommand;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateShapeCommand implements IShapeCommand {
    private String type;
    private ShapeParameters parameters;
}
