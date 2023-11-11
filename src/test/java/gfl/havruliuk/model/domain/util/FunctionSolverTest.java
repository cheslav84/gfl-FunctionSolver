package gfl.havruliuk.model.domain.util;

import gfl.havruliuk.model.domain.dataProvider.TestFunctionSolverDataProvider;
import gfl.havruliuk.model.domain.dataProvider.TestStreamProvider;
import gfl.havruliuk.model.domain.function.CompoundFunction;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FunctionSolverTest {
    private final double EPS = 1e-6;
    private FunctionSolver solver;

    @BeforeMethod
    public void setUp() {
        double compoundCondition = 1.4;
        double a = 2.7;
        double b = -0.3;
        double c = 4.0;
        solver = new FunctionSolver(new CompoundFunction(a, b, c, compoundCondition, EPS));
    }


    @Test(dataProvider = "testDataArraySize", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testArraySize(double start, double end, double interval, int steps) {
        assertThat(solver.getArraySize(start, end, interval)).isEqualTo(steps);
    }

    @Test(dataProvider = "testDataArraySizeNegative", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testArraySizeNegative(double start, double end, double interval, int steps) {
        assertThat(solver.getArraySize(start, end, interval)).isNotEqualTo(steps);
    }

    @Test(dataProvider = "testDataArraySizeStartLargerEndException", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testArraySizeStartLargerEndException(double start, double end, double interval) {
        assertThatThrownBy(() -> solver.getArraySize(start, end, interval))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The start of array can't be larger than the end of it.");
    }

    @Test(dataProvider = "testDataArraySizeIntervalNegativeOrZeroException", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testArraySizeIntervalNegativeOrZeroException(double start, double end, double interval) {
        assertThatThrownBy(() -> solver.getArraySize(start, end, interval))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Interval should be greater than 0.");
    }




    @Test(dataProvider = "testDataGetArgumentsArray", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testGetArgumentsArray(double start, double end, double interval, double[] arr) {
        assertThat(solver.getArgumentsArray(start, end, interval))
                .containsExactly(arr, Offset.offset(EPS))
                .startsWith(start)
                .isSorted()
                .doesNotHaveDuplicates()
                .doesNotContain(start - interval, end + interval)
        ;
    }


    @Test(dataProvider = "testDataGetFunctionValuesArray", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testGetFunctionValuesArray(double[] arguments, double[] functionValues) {
        assertThat(solver.getFunctionValuesArray(arguments))
                .containsExactly(functionValues, Offset.offset(EPS));
    }


    @Test
    public void testGetFunctionValuesArrayExceptionNull() {
        assertThatThrownBy(() -> solver.getFunctionValuesArray(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Array of arguments is null.");
    }


    @Test(dataProvider = "testDataGetMaxValueIndex", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testGetMaxValueIndex(double[] functionValues, int index) {
        assertThat(solver.getMaxValueIndex(functionValues)).isEqualTo(index);
    }

    @Test
    public void testGetMaxValueExceptionNull() {
        assertThatThrownBy(() -> solver.getMaxValueIndex(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Array of functionValues is null.");
    }

    @Test
    public void testGetMaxValueExceptionEmpty() {
        assertThatThrownBy(() -> solver.getMaxValueIndex(new double[]{}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Array is empty.");
    }

    @Test(dataProvider = "testDataGetMinValueIndex", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testGetMinValue(double[] functionValues, int index) {
        assertThat(solver.getMinValueIndex(functionValues)).isEqualTo(index);
    }

    @Test
    public void testGetMinValueExceptionNull() {
        assertThatThrownBy(() -> solver.getMinValueIndex(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Array of functionValues is null.");
    }

    @Test
    public void testGetMinValueExceptionEmpty() {
        assertThatThrownBy(() -> solver.getMinValueIndex(new double[]{}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Array is empty.");
    }



    @Test(dataProvider = "testDataGetSumOfValues", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testGetSumOfValues(double[] functionValues, double sum) {
        assertThat(solver.getSumOfValues(functionValues)).isCloseTo(sum, Percentage.withPercentage(0.3));
    }

    @Test
    public void testGetSumOfValuesExceptionNull() {
        assertThatThrownBy(() -> solver.getSumOfValues(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Array of functionValues is null.");
    }



    @Test(dataProvider = "testDataGetAvgValue", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testGetAvgValue(double[] functionValues, double maxValue) {
        assertThat(solver.getAverage(functionValues)).isCloseTo(maxValue, Percentage.withPercentage(0.3));
    }

    @Test
    public void testGetAvgValueExceptionNull() {
        assertThatThrownBy(() -> solver.getAverage(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Array of functionValues is null.");
    }

    @Test
    public void testGetAvgValueExceptionEmpty() {
        assertThatThrownBy(() -> solver.getAverage(new double[]{}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Array is empty.");
    }



    @Test(dataProvider = "testDataPrintMaxValueByIndex", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testPrintMaxValueByIndex(double[] functionValues, double maxValue) {
        TestStreamProvider.setUpOutputStream();
        int index = solver.getMaxValueIndex(functionValues);
        solver.printMaxValue(functionValues, index);
        String expected = "Maximum of function values is " + maxValue + System.lineSeparator();
        assertThat(TestStreamProvider.getConsoleContent().toString()).isEqualTo(expected);
        TestStreamProvider.tearDownOutputStream();
    }

    @Test(dataProvider = "testDataPrintMaxValueByIndexFailed", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testPrintMaxValueByIndexFailed(double[] functionValues, double maxValue) {
        TestStreamProvider.setUpOutputStream();
        int index = solver.getMaxValueIndex(functionValues);
        solver.printMaxValue(functionValues, index);
        String expected = "Maximum of function values is " + maxValue + System.lineSeparator();
        assertThat(TestStreamProvider.getConsoleContent().toString()).isNotEqualTo(expected);
        TestStreamProvider.tearDownOutputStream();
    }



    @Test(dataProvider = "testDataPrintMinValueByIndex", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testPrintMainValueByIndex(double[] functionValues, double minValue) {
        TestStreamProvider.setUpOutputStream();
        int index = solver.getMinValueIndex(functionValues);
        solver.printMinValue(functionValues, index);
        String expected = "Minimum of function values is " + minValue + System.lineSeparator();
        assertThat(TestStreamProvider.getConsoleContent().toString()).isEqualTo(expected);
        TestStreamProvider.tearDownOutputStream();
    }


    @Test(dataProvider = "testDataPrintMinValueByIndexFailed", dataProviderClass = TestFunctionSolverDataProvider.class)
    public void testPrintMainValueByIndexFailed(double[] functionValues, double minValue) {
        TestStreamProvider.setUpOutputStream();
        int index = solver.getMinValueIndex(functionValues);
        solver.printMinValue(functionValues, index);
        String expected = "Minimum of function values is " + minValue + System.lineSeparator();
        assertThat(TestStreamProvider.getConsoleContent().toString()).isNotEqualTo(expected);
        TestStreamProvider.tearDownOutputStream();
    }


}