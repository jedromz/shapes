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
//Triangle t = new Triangle;
//areaParameterFactory(t)
//post body:{type:triange,"parameters"{...}

//dodac area perimeter
//testy/
//jakas funkcjonalonsc
//security troche
