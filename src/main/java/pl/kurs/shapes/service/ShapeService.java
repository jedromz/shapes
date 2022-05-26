package pl.kurs.shapes.service;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kurs.shapes.error.EntityNotFoundException;
import pl.kurs.shapes.model.Shape;
import pl.kurs.shapes.model.command.SearchCriteriaCommand;
import pl.kurs.shapes.repository.ShapeRepository;
import pl.kurs.shapes.service.searchcriteria.ShapeSearchPredicateFactory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShapeService {
    private final ShapeRepository shapeRepository;
    private final ShapeSearchPredicateFactory criteriaFactory;

    @Transactional(readOnly = true)
    public Page<Shape> findAll(Pageable pageable, SearchCriteriaCommand command) {
        Predicate predicate = criteriaFactory.toPredicate(command);
        return shapeRepository.findAll(predicate, pageable);
    }

    public Shape save(Shape shape) {
        return shapeRepository.saveAndFlush(shape);
    }

    public Shape findById(Long id) throws EntityNotFoundException {
        return shapeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("id", String.valueOf(id)));
    }

    public void saveAll(List<Shape> shapes) {
        shapeRepository.saveAllAndFlush(shapes);
    }
}
