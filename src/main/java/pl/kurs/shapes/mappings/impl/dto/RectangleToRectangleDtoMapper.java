package pl.kurs.shapes.mappings.impl.dto;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.mappings.IShapeDtoMapper;
import pl.kurs.shapes.mappings.IShapeMapper;
import pl.kurs.shapes.model.Rectangle;
import pl.kurs.shapes.model.dto.RectangleDto;

@Service
@RequiredArgsConstructor
public class RectangleToRectangleDtoMapper implements IShapeDtoMapper<Rectangle, RectangleDto> {

    private final ModelMapper modelMapper;

    @Override
    public Class<Rectangle> type() {
        return Rectangle.class;
    }

    @Override
    public RectangleDto map(Rectangle source) {
        return modelMapper.map(source, RectangleDto.class);
    }
}
