package pl.kurs.shapes.service.searchcriteria.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.kurs.shapes.model.QRectangle;
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
    public Predicate toPredicate(SearchParameters searchParameters) {
        BooleanBuilder conditions = new BooleanBuilder();
        //bo inaczej w query mam alias 'triangle' i jest error ze nie ema czegos taekigo
        QRectangle qRectangle = new QRectangle("shape");
        Optional.ofNullable(searchParameters.getPerimeterFrom()).map(qRectangle.perimeter::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getPerimeterTo()).map(qRectangle.perimeter::loe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getAreaFrom()).map(qRectangle.area::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getAreaTo()).map(qRectangle.area::loe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getBaseFrom()).map(qRectangle.base::goe).ifPresent(conditions::and);
        Optional.ofNullable(searchParameters.getBaseTo()).map(qRectangle.base::loe).ifPresent(conditions::and);
        return conditions;
    }
}

