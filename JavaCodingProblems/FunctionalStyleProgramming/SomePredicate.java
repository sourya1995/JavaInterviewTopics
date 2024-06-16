package JavaCodingProblems.FunctionalStyleProgramming;

@FunctionalInterface
public interface SomePredicate<T> {
    boolean test(T value);
}
