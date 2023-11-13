package gfl.havruliuk.model.service;

import gfl.havruliuk.model.domain.Point;
import gfl.havruliuk.model.domain.ResultsDto;
import gfl.havruliuk.model.domain.util.FunctionSolver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolverService {

    public ResultsDto getResults(FunctionSolver solver, double rangeFrom, double rangeTo, double interval) {

        double[] argumentsArray = solver.getArgumentsArray(rangeFrom, rangeTo, interval);
        double[] functionValuesArray = solver.getFunctionValuesArray(argumentsArray);

        int maxValueIndex = solver.getMaxValueIndex(functionValuesArray);
        int minValueIndex = solver.getMinValueIndex(functionValuesArray);

        List<Point> points = getPoints(argumentsArray, functionValuesArray);


        return ResultsDto.builder()
                .maxValue(solver.getMaxValue(functionValuesArray, maxValueIndex))
                .minValue(solver.getMinValue(functionValuesArray, minValueIndex))
                .sumOfValues(solver.getSumOfValues(functionValuesArray))
                .average(solver.getAverage(functionValuesArray))
                .points(points)
                .build();
    }

    private List<Point> getPoints(double[] argumentsArray, double[] functionValuesArray) {
        return IntStream.range(0, argumentsArray.length)
                .mapToObj(i -> new Point(argumentsArray[i], functionValuesArray[i]))
                .collect(Collectors.toList());
    }


}
