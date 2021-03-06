package pl.kurs.shapes.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(exclude = "id") // woli zebym wygenerowal sam metody
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedBy
    private Instant updatedAt;
    @Version
    private int version;

    public abstract Double getArea();

    public abstract Double getPerimeter();
}
