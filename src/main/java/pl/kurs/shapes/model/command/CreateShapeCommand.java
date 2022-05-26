package pl.kurs.shapes.model.command;

import lombok.*;
import pl.kurs.shapes.mappings.IShapeCommand;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateShapeCommand implements IShapeCommand {
    @NotNull(message = "TYPE_NOT_NULL")
    private String type;
    @NotNull(message = "PARAMETERS_NOT_NULL")
    @Valid
    private ShapeParameters parameters;
}
