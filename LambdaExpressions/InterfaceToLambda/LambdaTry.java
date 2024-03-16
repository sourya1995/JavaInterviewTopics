package LambdaExpressions.InterfaceToLambda;

public class LambdaTry {
    public static void main(String[] args) {
        MathOperation isEven = new MathOperation() {

            @Override
            public boolean UnaryOperation(int num) {
               return num % 2 == 0;
            }
            
        };

        System.out.println(isEven.UnaryOperation(10)); // true
        System.out.println(isEven.UnaryOperation(11)); // false
    }
}
