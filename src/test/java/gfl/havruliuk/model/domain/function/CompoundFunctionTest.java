package gfl.havruliuk.model.domain.function;

import gfl.havruliuk.model.domain.dataProvider.TestFunctionDataProvider;
import org.assertj.core.data.Percentage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CompoundFunctionTest {

    private Function function;

    @BeforeMethod
    public void setUp() {
        double eps = 1e-6;
        double compoundCondition = 1.4;
        double a = 2.7;
        double b = -0.3;
        double c = 4.0;
        function = new CompoundFunction(a, b, c, compoundCondition, eps);
    }


    @Test(dataProvider = "testDataSolveFunction", dataProviderClass = TestFunctionDataProvider.class)
    public void solveFunctionPositive(double x, double y) {
        assertThat(function.solve(x)).isCloseTo(y, Percentage.withPercentage(0.3));
    }



    @Test
    public void testSolveFunctionTooSmall() {
        double minPossibleValue = -8.1e150;
        assertThatThrownBy(() -> function.solve(minPossibleValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The argument is too small to be evaluated.");
    }

    @Test
    public void testSolveFunctionTooLarge() {
        double maxPossibleValue = 8.1e150;
        assertThatThrownBy(() -> function.solve(maxPossibleValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The argument is too large to be evaluated.");
    }







}