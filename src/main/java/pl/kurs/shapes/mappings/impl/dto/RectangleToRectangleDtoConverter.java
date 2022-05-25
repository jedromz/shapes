package pl.kurs.shapes.mappings.impl.dto;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.model.Rectangle;
import pl.kurs.shapes.model.dto.RectangleDto;
import pl.kurs.shapes.model.dto.RectangleParameters;

@Service
public class RectangleToRectangleDtoConverter implements Converter<Rectangle, RectangleDto> {
    @Override
    public RectangleDto convert(MappingContext<Rectangle, RectangleDto> mappingContext) {
        Rectangle rectangle = mappingContext.getSource();
        return RectangleDto.builder()
                .area(rectangle.getArea())
                .perimeter(rectangle.getPerimeter())
                .createdAt(rectangle.getCreatedAt())
                .updatedAt(rectangle.getUpdatedAt())
                .rectangleParameters(new RectangleParameters(rectangle.getBase(), rectangle.getHeight()))
                .type("rectangle")
                .build();
    }
}
