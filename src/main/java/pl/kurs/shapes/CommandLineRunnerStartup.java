package pl.kurs.shapes;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kurs.shapes.model.Circle;
import pl.kurs.shapes.model.Triangle;
import pl.kurs.shapes.service.ShapeService;

@Component
@RequiredArgsConstructor
public class CommandLineRunnerStartup implements CommandLineRunner {

    private final ShapeService shapeService;

    @Override
    public void run(String... args) throws Exception {
        Triangle triangle = new Triangle(3.0, 3.0);
//        System.out.println(shapeFactory.getArea(triangle));
//        System.out.println(shapeFactory.getPerimeter(triangle));
//        System.out.println(shapeFactory.getArea(new Rectangle(1.0, 1.0)));
//        System.out.println(criteriaFactory.getMap().entrySet());
        shapeService.save(new Triangle(10.0, 10.0));
        shapeService.save(new Circle(10.0));

    }
}
