package gfl.havruliuk.model.service;

import gfl.havruliuk.model.domain.ResultsDto;
import gfl.havruliuk.model.domain.util.FunctionSolver;

public class SolverService {

    public ResultsDto getResults(FunctionSolver solver,double rangeFrom, double rangeTo, double interval) {

        double[] argumentsArray = solver.getArgumentsArray(rangeFrom, rangeTo, interval);
        double[] functionValuesArray = solver.getFunctionValuesArray(argumentsArray);

        int maxValueIndex = solver.getMaxValueIndex(functionValuesArray);
        int minValueIndex = solver.getMinValueIndex(functionValuesArray);

        return ResultsDto.builder()
                .maxValue(solver.getMaxValue(functionValuesArray, maxValueIndex))
                .minValue(solver.getMinValue(functionValuesArray, minValueIndex))
                .sumOfValues(solver.getSumOfValues(functionValuesArray))
                .average(solver.getAverage(functionValuesArray))
                .build();
    }

}
