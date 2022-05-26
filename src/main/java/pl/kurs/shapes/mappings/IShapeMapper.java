package pl.kurs.shapes.mappings;

import pl.kurs.shapes.error.MissingParameterException;

public interface IShapeMapper<S,D> {
    String type();
    D map(S source) throws MissingParameterException;
}
