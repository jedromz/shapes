package pl.kurs.shapes.service.searchcriteria.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.model.QCircle;
import pl.kurs.shapes.model.QTriangle;
import pl.kurs.shapes.model.command.SearchParameters;
import pl.kurs.shapes.service.searchcriteria.ISearchCriteria;

import java.util.Optional;

@Service
@Getter
@Setter
public class CircleSearchCriteria implements ISearchCriteria {
    @Override
    public String type() {
        return "circle";
    }

    @Override
    public Predicate toPredicate(SearchParameters searchParameters) {
        BooleanBuilder conditions = new BooleanBuilder();
        //bo inaczej w query mam alias 'circle' i jest error ze nie ema czegos taekigo
        QCircle qCircle = new QCircle("shape");
        addConditions(searchParameters, conditions, qCircle);
        return conditions;
    }

    private void addConditions(SearchParameters searchParameters, BooleanBuilder conditions, QCircle qCircle) {
        Optional.ofNullable(searchParameters.getPerimeterFrom()).map(qCircle.perimeter::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getPerimeterTo()).map(qCircle.perimeter::loe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getAreaFrom()).map(qCircle.area::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getAreaTo()).map(qCircle.area::loe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getRadiusFrom()).map(qCircle.radius::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getRadiusTo()).map(qCircle.radius::loe).ifPresent(conditions::and);
    }
}
