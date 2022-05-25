package pl.kurs.shapes.mappings.impl.dto;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.mappings.IShapeDtoMapper;
import pl.kurs.shapes.model.Triangle;
import pl.kurs.shapes.model.dto.TriangleDto;

@Service
@RequiredArgsConstructor
public class TriangleToTriangleDtoMapperI implements IShapeDtoMapper<Triangle, TriangleDto> {

    private final ModelMapper modelMapper;

    @Override
    public Class<Triangle> type() {
        return Triangle.class;
    }

    @Override
    public TriangleDto map(Triangle source) {
        return modelMapper.map(source, TriangleDto.class);
    }
}
