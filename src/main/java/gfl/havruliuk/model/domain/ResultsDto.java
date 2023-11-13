package gfl.havruliuk.model.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResultsDto {

    private double maxValue;
    private double minValue;
    private double sumOfValues;
    private double average;
    private List<Point> points;

}
