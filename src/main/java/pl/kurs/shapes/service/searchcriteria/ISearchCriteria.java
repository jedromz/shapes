package pl.kurs.shapes.service.searchcriteria;

import com.querydsl.core.types.Predicate;
import pl.kurs.shapes.model.command.SearchParameters;

public interface ISearchCriteria {

    String type();

    Predicate toPredicate(SearchParameters searchParameters);

}
