package pl.kurs.shapes.error;

import lombok.Value;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MissingParameterException.class)
    public ResponseEntity handleMissingParameterException(MissingParameterException exc) {
        String parameter = exc.getParameter();
        String message = exc.getMessage();
        return new ResponseEntity(new MissingParameterDto(parameter, message), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(javax.validation.ConstraintViolationException exc) {
        String message = exc.getMessage();
        return new ResponseEntity(new ValidationErrorDto(message), HttpStatus.BAD_REQUEST);
    }

    @Value
    class MissingParameterDto {
        private String parameter;
        private String message;
    }

    @Value
    class OptimisticLockDto {
        private String message;
    }

    @Value
    class ValidationErrorDto {
        private String message;
    }
}
