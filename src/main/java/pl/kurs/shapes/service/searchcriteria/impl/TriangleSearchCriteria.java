package pl.kurs.shapes.service.searchcriteria.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.model.QShape;
import pl.kurs.shapes.model.QTriangle;
import pl.kurs.shapes.model.ShapeType;
import pl.kurs.shapes.model.command.SearchCriteriaCommand;
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
    public Predicate toPredicate(SearchCriteriaCommand command) {
        BooleanBuilder conditions = new BooleanBuilder();
        QTriangle qTriangle = new QTriangle("shape");
        if (command.getSearchParameters() == null && command.getType() != null) {
            Optional.of(type()).map(qTriangle.type.stringValue()::equalsIgnoreCase).ifPresent(conditions::and);
            return conditions;
        }
        addConditions(command.getSearchParameters(), conditions, qTriangle);
        return conditions;
    }

    private void addConditions(SearchParameters searchParameters, BooleanBuilder conditions, QTriangle qTriangle) {
        Optional.of(type()).map(qTriangle.type.stringValue()::equalsIgnoreCase).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getSideAFrom()).map(qTriangle.sideA::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getSideBFrom()).map(qTriangle.sideB::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getSideCFrom()).map(qTriangle.sideC::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getSideATo()).map(qTriangle.sideA::loe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getSideBTo()).map(qTriangle.sideB::loe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getSideBTo()).map(qTriangle.sideC::loe).ifPresent(conditions::and);
    }
}
