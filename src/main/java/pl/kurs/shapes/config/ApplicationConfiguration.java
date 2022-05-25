package pl.kurs.shapes.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pl.kurs.shapes.mappings.IShapeDtoMapper;
import pl.kurs.shapes.mappings.IShapeMapper;
import pl.kurs.shapes.mappings.impl.ShapeMapperFactory;
import pl.kurs.shapes.service.searchcriteria.ISearchCriteria;
import pl.kurs.shapes.service.searchcriteria.ShapeSearchPredicateFactory;

import java.util.Set;

@Configuration
@EnableJpaAuditing
public class ApplicationConfiguration {

    @Bean
    public ShapeSearchPredicateFactory criteriaFactory(Set<ISearchCriteria> shapes) {
        ShapeSearchPredicateFactory criteriaFactory = new ShapeSearchPredicateFactory();
        shapes.forEach(criteriaFactory::addCriteria);
        return criteriaFactory;
    }

    @Bean
    public ShapeMapperFactory shapeMapperFactory(Set<IShapeMapper> IShapeMappers, Set<IShapeDtoMapper> dtoMappers) {
        ShapeMapperFactory shapeMapperFactory = new ShapeMapperFactory();
        IShapeMappers.forEach(shapeMapperFactory::addMapper);
        dtoMappers.forEach(shapeMapperFactory::addDtoMapper);
        return shapeMapperFactory;
    }

    @Bean
    public ModelMapper modelMapper(Set<Converter> converters) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        converters.forEach(modelMapper::addConverter);
        return modelMapper;
    }
}
