package gfl.havruliuk.model.domain.function;

import gfl.havruliuk.model.domain.util.Validator;

public class FirstFunction  implements Function {

    private final double a;
    private final double b;
    private final double c;

    public FirstFunction(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double solve(double x) {
        Validator.validateArgument(x);
        return a * Math.pow(x, 2) + b * x + c;
    }
}
