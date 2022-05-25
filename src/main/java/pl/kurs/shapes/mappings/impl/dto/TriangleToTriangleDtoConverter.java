package pl.kurs.shapes.mappings.impl.dto;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.model.Triangle;
import pl.kurs.shapes.model.dto.TriangleDto;
import pl.kurs.shapes.model.dto.parameters.TriangleParameters;

@Service
@RequiredArgsConstructor
public class TriangleToTriangleDtoConverter implements Converter<Triangle, TriangleDto> {

    @Override
    public TriangleDto convert(MappingContext<Triangle, TriangleDto> mappingContext) {
        Triangle triangle = mappingContext.getSource();
        return TriangleDto.builder()
                .type("triangle")
                .createdAt(triangle.getCreatedAt())
                .updatedAt(triangle.getUpdatedAt())
                .triangleParameters(new TriangleParameters(triangle.getBase(), triangle.getHeight()))
                .area(triangle.getArea())
                .perimeter(triangle.getPerimeter())
                .build();
    }
}
