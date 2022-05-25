package pl.kurs.shapes.mappings;

public interface IShapeMapper<S,D> {
    String type();
    D map(S source);
}
