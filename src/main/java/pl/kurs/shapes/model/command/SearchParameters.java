package pl.kurs.shapes.model.command;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchParameters {
    private Double baseFrom;
    private Double baseTo;
    private Double heightFrom;
    private Double heightTo;
    private Double radiusFrom;
    private Double radiusTo;
    private Double areaFrom;
    private Double areaTo;
    private Double perimeterFrom;
    private Double perimeterTo;
    private Double sideAFrom;
    private Double sideBFrom;
    private Double sideCFrom;
    private Double sideATo;
    private Double sideBTo;
    private Double sideCTo;
}
