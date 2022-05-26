package pl.kurs.shapes.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.shapes.mappings.impl.ShapeMapperFactory;
import pl.kurs.shapes.model.Shape;
import pl.kurs.shapes.model.command.CreateShapeCommand;
import pl.kurs.shapes.model.command.SearchCriteriaCommand;
import pl.kurs.shapes.model.dto.ShapeDto;
import pl.kurs.shapes.service.ShapeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/shapes")
@RequiredArgsConstructor
public class ShapeController {

    private final ShapeService shapeService;
    private final ShapeMapperFactory shapeMapperFactory;

    @PostMapping
    @SneakyThrows
    public ResponseEntity<Shape> addShape(@RequestBody @Valid CreateShapeCommand command) {

        //wtedy moglbym uzyc zwyklego mappera, ale jakies to takie brzydkie + jak sie zmienia jakies nazwy to lipa
        //Class<?> cls = Class.forName("StringUtils.capitalize(command.getType() + ".class");");
        //modelMapper.map(command,cls) -> modelMapper.map(command,Triangle.class)
        // i wtedy mam po prostu Converter<Commmand,Triangle>
        Shape shape = shapeService.save(shapeMapperFactory.map(command));
        ShapeDto shapeDto = shapeMapperFactory.mapToDto(shape);
        return new ResponseEntity(shapeDto, HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<ShapeDto>> getAllShapes(@PageableDefault Pageable pageable, @RequestBody @Valid SearchCriteriaCommand criteria) {
        return ResponseEntity.ok(shapeService.findAll(pageable, criteria)
                .map(shapeMapperFactory::mapToDto));
    }

    @GetMapping("/{id}")
    @SneakyThrows
    public ResponseEntity<ShapeDto> getShape(@PathVariable Long id) {
        return ResponseEntity.ok(shapeMapperFactory.mapToDto(shapeService.findById(id)));
    }
}
