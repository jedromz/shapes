package pl.kurs.shapes.mappings.impl.dto;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.mappings.IShapeDtoMapper;
import pl.kurs.shapes.model.Circle;
import pl.kurs.shapes.model.dto.CircleDto;

@Service
@RequiredArgsConstructor
public class CircleToCircleDtoMapperI implements IShapeDtoMapper<Circle, CircleDto> {
    private final ModelMapper modelMapper;

    @Override
    public Class<Circle> type() {
        return Circle.class;
    }

    @Override
    public CircleDto map(Circle source) {
        return modelMapper.map(source, CircleDto.class);
    }
}
