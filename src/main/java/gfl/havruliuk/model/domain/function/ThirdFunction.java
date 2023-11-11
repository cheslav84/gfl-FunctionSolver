package gfl.havruliuk.model.domain.function;

import gfl.havruliuk.model.domain.util.Validator;

public class ThirdFunction implements Function {

    private final double a;
    private final double b;

    public ThirdFunction(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double solve(double x) {
        Validator.validateArgument(x);
        return (a + b * x) / Math.sqrt(Math.pow(x, 2) + 1);
    }
}
