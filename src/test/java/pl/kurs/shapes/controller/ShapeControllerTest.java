package pl.kurs.shapes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.w3c.dom.css.Rect;
import pl.kurs.shapes.ShapesApplication;
import pl.kurs.shapes.model.Circle;
import pl.kurs.shapes.model.Rectangle;
import pl.kurs.shapes.model.Shape;
import pl.kurs.shapes.model.Triangle;
import pl.kurs.shapes.model.command.CreateShapeCommand;
import pl.kurs.shapes.model.command.SearchCriteriaCommand;
import pl.kurs.shapes.model.command.SearchParameters;
import pl.kurs.shapes.model.command.ShapeParameters;
import pl.kurs.shapes.model.dto.parameters.TriangleParameters;
import pl.kurs.shapes.repository.ShapeRepository;
import pl.kurs.shapes.service.ShapeService;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = ShapesApplication.class)
@AutoConfigureMockMvc
class ShapeControllerTest {
    @BeforeEach
    void clean() {
        shapeRepository.deleteAll();
    }

    //podkresla ale dziala
    @Autowired
    private MockMvc postman;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ShapeRepository shapeRepository;
    @Autowired
    private ShapeService shapeService;

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldAddSingleTriangle() {
        //given
        CreateShapeCommand command = CreateShapeCommand
                .builder()
                .type("triangle")
                .parameters(ShapeParameters.builder()
                        .sideA(10.0)
                        .sideB(10.0)
                        .sideC(10.0)
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        String response = postman.perform(post("/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        int savedId = JsonPath.read(response, "id");
        //then
        postman.perform(get("/shapes/" + savedId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.parameters.sideA").value(command.getParameters().getSideA()))
                .andExpect(jsonPath("$.parameters.sideB").value(command.getParameters().getSideB()))
                .andExpect(jsonPath("$.parameters.sideC").value(command.getParameters().getSideC()))
                .andReturn();
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldNotAddInvalidTriangle() {
        //given
        CreateShapeCommand command = CreateShapeCommand
                .builder()
                .type("triangle")
                .parameters(ShapeParameters.builder()
                        .sideA(40.0)
                        .sideB(10.0)
                        .sideC(10.0)
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        postman.perform(post("/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldNotAddNegativeTriangle() {
        //given
        CreateShapeCommand command = CreateShapeCommand
                .builder()
                .type("triangle")
                .parameters(ShapeParameters.builder()
                        .sideA(-40.0)
                        .sideB(-10.0)
                        .sideC(-10.0)
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        postman.perform(post("/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldNotAddTriangleWithMissingParams() {
        //given
        CreateShapeCommand command = CreateShapeCommand
                .builder()
                .type("triangle")
                .parameters(ShapeParameters.builder()
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        postman.perform(post("/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldAddSingleRectangle() {
        //given
        CreateShapeCommand command = CreateShapeCommand
                .builder()
                .type("rectangle")
                .parameters(ShapeParameters.builder()
                        .base(10.0)
                        .height(10.0)
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        String response = postman.perform(post("/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        int savedId = JsonPath.read(response, "id");
        //then
        postman.perform(get("/shapes/" + savedId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.parameters.base").value(command.getParameters().getBase()))
                .andExpect(jsonPath("$.parameters.height").value(command.getParameters().getHeight()))
                .andReturn();
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldNotAddRectangleWithMissingParams() {
        //given
        CreateShapeCommand command = CreateShapeCommand
                .builder()
                .type("rectangle")
                .parameters(ShapeParameters.builder()
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        postman.perform(post("/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldNotAddNegativeRectangle() {
        //given
        CreateShapeCommand command = CreateShapeCommand
                .builder()
                .type("rectangle")
                .parameters(ShapeParameters.builder()
                        .base(-10.0)
                        .height(-10.0)
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        postman.perform(post("/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldAddSingleCircle() {
        //given
        CreateShapeCommand command = CreateShapeCommand
                .builder()
                .type("circle")
                .parameters(ShapeParameters.builder()
                        .radius(10.0)
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        String response = postman.perform(post("/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        int savedId = JsonPath.read(response, "id");
        //then
        postman.perform(get("/shapes/" + savedId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.parameters.radius").value(command.getParameters().getRadius()))
                .andReturn();
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldNotAddCircleWithMissingParams() {
        //given
        CreateShapeCommand command = CreateShapeCommand
                .builder()
                .type("circle")
                .parameters(ShapeParameters.builder()
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        postman.perform(post("/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldNotAddNegativeCircle() {
        //given
        CreateShapeCommand command = CreateShapeCommand
                .builder()
                .type("circle")
                .parameters(ShapeParameters.builder()
                        .radius(-10.0)
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        postman.perform(post("/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldGetTrianglesByParameters() {
        //given
        Triangle triangle1 = new Triangle(10.0, 10.0, 10.0);
        Triangle triangle2 = new Triangle(1.0, 1.0, 1.0);
        Triangle triangle3 = new Triangle(100.0, 100.0, 100.0);
        shapeService.saveAll(List.of(triangle1, triangle2, triangle3));
        SearchCriteriaCommand command = SearchCriteriaCommand.builder()
                .type("triangle")
                .searchParameters(SearchParameters.builder()
                        .sideAFrom(3.0)
                        .sideATo(20.0)
                        .sideBFrom(5.0)
                        .sideBTo(100.0)
                        .sideCFrom(1.0)
                        .sideCTo(5.0)
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        String response = postman.perform(post("/shapes/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[*].type").value(containsInAnyOrder(command.getType(),
                        command.getType(),
                        command.getType())))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldGetRectangleByParameters() {
        //given
        Rectangle rectangle1 = new Rectangle(10.0, 10.0);
        Rectangle rectangle2 = new Rectangle(1.0, 1.0);
        Rectangle rectangle3 = new Rectangle(100.0, 100.0);
        shapeService.saveAll(List.of(rectangle1, rectangle2, rectangle3));
        SearchCriteriaCommand command = SearchCriteriaCommand.builder()
                .type("rectangle")
                .searchParameters(SearchParameters.builder()
                        .baseFrom(10.0)
                        .baseTo(10.0)
                        .heightFrom(10.0)
                        .heightTo(10.0)
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        String response = postman.perform(post("/shapes/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[*].type").value(containsInAnyOrder(command.getType(),
                        command.getType(),
                        command.getType())))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    @SneakyThrows
    @WithMockUser(username = "admin")
    void shouldGetCircleByParameters() {
        //given
        double RADIUS_FROM = 10.0;
        double RADIUS_TO = 100.0;
        Circle circle1 = new Circle(RADIUS_FROM);
        Circle circle2 = new Circle(RADIUS_TO);
        Circle circle3 = new Circle(RADIUS_TO + 10);
        shapeService.saveAll(List.of(circle1, circle2, circle3));
        SearchCriteriaCommand command = SearchCriteriaCommand.builder()
                .type("circle")
                .searchParameters(SearchParameters.builder()
                        .radiusFrom(10.0)
                        .radiusTo(10.0)
                        .build())
                .build();
        String requestJson = objectMapper.writeValueAsString(
                command);
        //when
        String response = postman.perform(post("/shapes/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[*].type").value(containsInAnyOrder(command.getType(),
                        command.getType())))
                .andExpect(jsonPath("$.content[*].parameters.radius").value(containsInAnyOrder(RADIUS_FROM,
                        RADIUS_TO)))
                .andReturn().getResponse().getContentAsString();
    }
}
