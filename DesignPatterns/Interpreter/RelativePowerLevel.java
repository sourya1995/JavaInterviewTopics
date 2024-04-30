package DesignPatterns.Interpreter;

import java.beans.Expression;
import java.rmi.server.Operation;

public class RelativePowerLevel implements PowerLevelExpression{

    private PowerLevelExpression expression;
    private String operation;
    private int value;

    

    public RelativePowerLevel(PowerLevelExpression expression, String operation, int value) {
        this.expression = expression;
        this.operation = operation;
        this.value = value;
    }



    @Override
    public int interpret(PowerLevelContext context) {
       int powerLevel = expression.interpret(context);
       if(operation.equals("double")) {
        return powerLevel * 2;
       } else if(operation.equals("over")) {
            return powerLevel + value;
       }

       return 0;
       
    }
    
}
