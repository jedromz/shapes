package pl.kurs.shapes.mappings;

public interface IShapeDtoMapper<S, D> {
    Class<S> type();

    D map(S source);
}
