package gfl.havruliuk.model.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultsDto {

    private double maxValue;
    private double minValue;
    private double sumOfValues;
    private double average;



    //        System.out.println("Maximum of function values is " + functionValues[index]);
//        System.out.println("Minimum of function values is " + functionValues[index]);
//        System.out.println("The sum of function values is " + solver.getSumOfValues(functionValuesArray));
//        System.out.println("Average function value is " + solver.getAverage(functionValuesArray));

}
