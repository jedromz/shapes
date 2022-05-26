package pl.kurs.shapes.error;

import lombok.Value;

@Value
public class MissingParameterException extends Exception {
    private String parameter;
    private String message = "PARAMETER_MISSING";
}
