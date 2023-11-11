package gfl.havruliuk.model.domain.util;

public class Validator {

    public static void validateArgument(double x) {
        double minPossibleValue = -8.0e150;
        double maxPossibleValue = 8.0e150;
        if (x < minPossibleValue) {
            throw new IllegalArgumentException("The argument is too small to be evaluated.");
        } else if (x > maxPossibleValue) {
            throw new IllegalArgumentException("The argument is too large to be evaluated.");
        }
    }
}
