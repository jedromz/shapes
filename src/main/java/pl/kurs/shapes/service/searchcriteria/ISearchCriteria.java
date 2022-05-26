package pl.kurs.shapes.service.searchcriteria;

import com.querydsl.core.types.Predicate;
import pl.kurs.shapes.model.command.SearchCriteriaCommand;

public interface ISearchCriteria {

    String type();

    Predicate toPredicate(SearchCriteriaCommand command);

}
