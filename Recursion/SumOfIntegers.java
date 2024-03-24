package Recursion;

public class SumOfIntegers {
    public int sum(final int n){
        if(n > 0){
            return  n + sum(n - 1);
        }else {
            return n;
        }
    }
}
