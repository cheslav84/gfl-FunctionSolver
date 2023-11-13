package gfl.havruliuk.model.domain.util;


import gfl.havruliuk.model.domain.function.Function;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FunctionSolver {
    private final Function function;

    public FunctionSolver(Function function) {
        this.function = function;
    }

    public int getArraySize(double start, double end, double interval) {
        if (start > end) throw new IllegalArgumentException("The start of array can't be larger than the end of it.");
        if (interval <= 0) throw new IllegalArgumentException("Interval should be greater than 0.");
//        return (int) (Math.round(end - start)/interval) + 1;
        return (int) ((end - start)/interval + 1);
    }


    public double[] getArgumentsArray(double start, double end, double interval) {
        int size = getArraySize(start, end, interval);
        return IntStream.range(0, size)
                .mapToDouble(i -> start + i * interval)
                .toArray();
    }

    public double[] getFunctionValuesArray (double[] arguments) {
        if(arguments == null) throw new IllegalArgumentException("Array of arguments is null.");
        return Arrays.stream(arguments)
                .map(function::solve)
                .toArray();
    }

    public int getMaxValueIndex(double[] functionValues) {
        if(functionValues == null) throw new IllegalArgumentException("Array of functionValues is null.");
        return IntStream.range(0, functionValues.length)
                .reduce((a,b) -> functionValues[a] < functionValues[b] ? b : a)
                .orElseThrow(() -> new IllegalArgumentException("Array is empty."));
    }


    public int getMinValueIndex(double[] functionValues) {
        if(functionValues == null) throw new IllegalArgumentException("Array of functionValues is null.");
        return IntStream.range(0, functionValues.length)
                .reduce((a,b) -> functionValues[a] > functionValues[b] ? b : a)
                .orElseThrow(() -> new IllegalArgumentException("Array is empty."));
    }

    public double getSumOfValues (double[] functionValues) {
        if(functionValues == null) throw new IllegalArgumentException("Array of functionValues is null.");
        return Arrays.stream(functionValues).sum();
    }

    public double getAverage (double[] functionValues) {
        if(functionValues == null) throw new IllegalArgumentException("Array of functionValues is null.");
        return Arrays.stream(functionValues).average().orElseThrow(() -> new IllegalArgumentException("Array is empty."));
    }


    public void printMaxValue(double[] functionValues, int index) {
        System.out.println("Maximum of function values is " + functionValues[index]);
    }
    public double getMaxValue(double[] functionValues, int index) {
        return functionValues[index];
    }


    public void printMinValue(double[] functionValues, int index) {
        System.out.println("Minimum of function values is " + functionValues[index]);
    }

    public double getMinValue(double[] functionValues, int index) {
        return functionValues[index];
    }
}
