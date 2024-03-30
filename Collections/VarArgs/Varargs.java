package Collections.VarArgs;

public class Varargs {
    void printVarArgArray(int...x){
        for(int i=0; i<x.length; i++){
            System.out.println(x[i] + ",");
        }
    }

    public static void main(String[] args) {
        Varargs obj = new Varargs();
        int[] testArray = new int[]  {1,2,3,4,5,6,7,8};
        obj.printVarArgArray(testArray);

        obj.printVarArgArray(1,2,3,3,4);
    }
}
