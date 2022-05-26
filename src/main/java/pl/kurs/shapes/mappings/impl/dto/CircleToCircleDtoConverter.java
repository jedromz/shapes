package pl.kurs.shapes.mappings.impl.dto;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.model.Circle;
import pl.kurs.shapes.model.dto.CircleDto;
import pl.kurs.shapes.model.dto.parameters.CircleParameters;

@Service
public class CircleToCircleDtoConverter implements Converter<Circle, CircleDto> {
    @Override
    public CircleDto convert(MappingContext<Circle, CircleDto> mappingContext) {
        Circle circle = mappingContext.getSource();
        return CircleDto.builder()
                .id(circle.getId())
                .type("circle")
                .createdAt(circle.getCreatedAt())
                .updatedAt(circle.getUpdatedAt())
                .circleParameters(new CircleParameters(circle.getRadius()))
                .area(circle.getArea())
                .perimeter(circle.getPerimeter())
                .build();
    }
}
