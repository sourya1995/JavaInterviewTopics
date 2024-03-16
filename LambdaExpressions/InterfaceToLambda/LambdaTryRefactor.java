package LambdaExpressions.InterfaceToLambda;

public class LambdaTryRefactor {
    
    public static void main(String[] args) {
        MathOperation isEven = num ->  num % 2 == 0;
        System.out.println(isEven.UnaryOperation(10)); // true
        System.out.println(isEven.UnaryOperation(11)); // false
    }
}

