package pl.kurs.shapes.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kurs.shapes.mappings.IShapeCommand;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateShapeCommand implements IShapeCommand {
    @NotNull(message = "TYPE_NOT_NULL")
    private String type;
    @NotNull(message = "PARAMETERS_NOT_NULL")
    @Valid
    private ShapeParameters parameters;
}
