package pl.kurs.shapes.service.searchcriteria.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.model.QTriangle;
import pl.kurs.shapes.model.command.SearchParameters;
import pl.kurs.shapes.service.searchcriteria.ISearchCriteria;

import java.util.*;

@Service
@Getter
@Setter
public class TriangleSearchCriteria implements ISearchCriteria {

    @Override
    public String type() {
        return "triangle";
    }

    @Override
    public Predicate toPredicate(SearchParameters searchParameters) {
        BooleanBuilder conditions = new BooleanBuilder();
        //bo inaczej w query mam alias 'triangle' i jest error ze nie ema czegos taekigo
        QTriangle qTriangle = new QTriangle("shape");
        addConditions(searchParameters, conditions, qTriangle);
        return conditions;
    }

    private void addConditions(SearchParameters searchParameters, BooleanBuilder conditions, QTriangle qTriangle) {
        Optional.ofNullable(searchParameters.getPerimeterFrom()).map(qTriangle.perimeter::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getPerimeterTo()).map(qTriangle.perimeter::loe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getAreaFrom()).map(qTriangle.area::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getAreaTo()).map(qTriangle.area::loe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getBaseFrom()).map(qTriangle.base::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getBaseTo()).map(qTriangle.base::loe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getHeightFrom()).map(qTriangle.height::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getHeightTo()).map(qTriangle.height::loe).ifPresent(conditions::and);
    }
}
