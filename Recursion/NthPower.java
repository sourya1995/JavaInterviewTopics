package Recursion;

public class NthPower {
    public long power(final int num, final int exp){
        if(exp == 0){
            return 1;
        }

        if(exp == 1) {
            return num;
        }

        return num * power(num, exp - 1);
    }
}
