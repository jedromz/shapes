package pl.kurs.shapes.service;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.model.Shape;
import pl.kurs.shapes.model.Triangle;
import pl.kurs.shapes.model.command.SearchCriteriaCommand;
import pl.kurs.shapes.service.searchcriteria.ShapeSearchPredicateFactory;
import pl.kurs.shapes.repository.ShapeRepository;

@Service
@RequiredArgsConstructor
public class ShapeService {
    private final ShapeRepository shapeRepository;
    private final ShapeSearchPredicateFactory criteriaFactory;

    public Page<Shape> findAll(Pageable pageable, SearchCriteriaCommand criteria) {
        Predicate predicate = criteriaFactory.toPredicate(criteria.getType(), criteria.getSearchParameters());
        return shapeRepository.findAll(predicate, pageable);
    }

    public void save(Triangle triangle) {
        shapeRepository.save(triangle);
    }

    public Shape save(Shape shape) {
        return shapeRepository.saveAndFlush(shape);
    }

}
