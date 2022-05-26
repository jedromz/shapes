package pl.kurs.shapes.validation.implementation;

import pl.kurs.shapes.model.command.ITriangleParameters;
import pl.kurs.shapes.validation.annotation.Triangle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TriangleValidator implements ConstraintValidator<Triangle, ITriangleParameters> {
    @Override
    public boolean isValid(ITriangleParameters iTriangleParameters, ConstraintValidatorContext constraintValidatorContext) {
        return checkSides(iTriangleParameters.getSideA(), iTriangleParameters.getSideB(), iTriangleParameters.getSideC());
    }

    private boolean checkSides(Double sideOne, Double sideTwo, Double sideThree) {
        return sideOne < sideTwo + sideThree && sideTwo < sideThree + sideOne && sideThree < sideOne + sideTwo;
    }
}
