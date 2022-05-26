package pl.kurs.shapes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.kurs.shapes.model.Shape;

public interface ShapeRepository extends JpaRepository<Shape, Long>, QuerydslPredicateExecutor<Shape> {

}
