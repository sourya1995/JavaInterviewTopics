package JavaCodingProblems.FunctionalStyleProgramming;

@FunctionalInterface
public interface TriFunctionPredicate<T, U, V, R> {
    R apply(T t, U u, V v);
}
