package pl.kurs.shapes.service.searchcriteria;

import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.model.command.SearchCriteriaCommand;
import pl.kurs.shapes.model.command.SearchParameters;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@Service
public class ShapeSearchPredicateFactory {
    private final Map<String, ISearchCriteria> map = new HashMap<>();

    public void addCriteria(ISearchCriteria criteria) {
        map.put(criteria.type(), criteria);
    }

    public Predicate toPredicate(SearchCriteriaCommand command) {
        return map.get(command.getType()).toPredicate(command);
    }
}
