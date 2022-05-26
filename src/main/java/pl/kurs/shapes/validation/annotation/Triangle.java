package pl.kurs.shapes.validation.annotation;

import pl.kurs.shapes.validation.implementation.TriangleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TriangleValidator.class)
public @interface Triangle {
    String message() default "INVALID_TRIANGLE";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
