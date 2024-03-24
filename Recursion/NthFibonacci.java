package Recursion;

public class NthFibonacci {
    public int fib(final int n){
        if(n > 2){
            return fib(n-2) + fib(n-1); //the function is called twice for each recursive iteration
        }
        return 1;
    }
}
