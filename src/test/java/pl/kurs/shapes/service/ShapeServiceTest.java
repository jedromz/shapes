package pl.kurs.shapes.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kurs.shapes.model.Circle;
import pl.kurs.shapes.model.Rectangle;
import pl.kurs.shapes.model.Shape;
import pl.kurs.shapes.model.Triangle;
import pl.kurs.shapes.repository.ShapeRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShapeServiceTest {

    private ShapeService shapeService;
    @Mock
    private ShapeRepository shapeRepository;
    private List<Shape> shapes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Shape SHAPE_1 = new Triangle(10.0, 10.0, 10.0);
        Shape SHAPE_2 = new Rectangle(25.0, 2.0);
        Shape SHAPE_3 = new Circle(5.0);
        shapes = new ArrayList<>(List.of(SHAPE_1, SHAPE_2, SHAPE_3));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }
}
