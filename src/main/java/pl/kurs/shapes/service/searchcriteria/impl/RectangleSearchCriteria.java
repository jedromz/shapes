package pl.kurs.shapes.service.searchcriteria.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.model.QRectangle;
import pl.kurs.shapes.model.ShapeType;
import pl.kurs.shapes.model.command.SearchCriteriaCommand;
import pl.kurs.shapes.model.command.SearchParameters;
import pl.kurs.shapes.service.searchcriteria.ISearchCriteria;

import java.util.Optional;

@Service
@Getter
@Setter
public class RectangleSearchCriteria implements ISearchCriteria {

    @Override
    public String type() {
        return "rectangle";
    }


    @Override
    public Predicate toPredicate(SearchCriteriaCommand command) {
        BooleanBuilder conditions = new BooleanBuilder();
        //bo inaczej w query mam alias 'triangle' i jest error ze nie ema czegos taekigo
        QRectangle qRectangle = new QRectangle("shape");
        if (command.getSearchParameters() == null) {
            Optional.of(type()).map(qRectangle.type.stringValue()::equalsIgnoreCase).ifPresent(conditions::and);
            return conditions;
        }
        addConditions(command.getSearchParameters(), conditions, qRectangle);
        return conditions;
    }

    private void addConditions(SearchParameters searchParameters, BooleanBuilder conditions, QRectangle qRectangle) {
        Optional.of(type()).map(qRectangle.type.stringValue()::equalsIgnoreCase).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getBaseFrom()).map(qRectangle.base::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getBaseTo()).map(qRectangle.base::loe).ifPresent(conditions::and);
    }
}

