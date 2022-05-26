package pl.kurs.shapes;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ShapesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShapesApplication.class, args);
    }

}
//pole i obwod robic w liquibase?
//jak w mockmvc jsonpath sprawdzic czy wartos jest spelnia filtr, np czy dla
// kazdego obiektu w Page podstawa trojkata jest mneijsza niz 3
