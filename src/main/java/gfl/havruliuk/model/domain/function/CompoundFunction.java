package gfl.havruliuk.model.domain.function;

public class CompoundFunction implements Function {
    private final double compoundCondition;
    private final double eps;
    private final Function firstFunction;
    private final Function secondFunction;
    private final Function thirdFunction;


    public CompoundFunction(double a, double b, double c, double compoundCondition, double eps) {
        this.compoundCondition = compoundCondition;
        this.eps = eps;
        firstFunction = new FirstFunction(a, b, c);
        secondFunction = new SecondFunction(a);
        thirdFunction = new ThirdFunction(a, b);
    }


    @Override
    public double solve(double x) {
        return x < compoundCondition - eps ? firstFunction.solve(x)
                : x > compoundCondition + eps ? thirdFunction.solve(x)
                : secondFunction.solve(x);
    }
}
