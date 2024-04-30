package DesignPatterns.Interpreter;

public class Main {
    public static void main(String[] args) {
        PowerLevelContext context = new PowerLevelContext();

        PowerLevelExpression gokuPowerLevel = new CharacterPowerLevel("Goku");
        PowerLevelExpression vegetaPowerLevel = new CharacterPowerLevel("Vegeta");
        PowerLevelExpression vegetaDoublePowerLevel = new RelativePowerLevel(vegetaPowerLevel, "double", 0);
        PowerLevelExpression gokuPlusThousand = new RelativePowerLevel(gokuPowerLevel, "over", 1000);

        System.out.println("Goku's power level: " + gokuPowerLevel.interpret(context));
        System.out.println("Vegeta's power level: " + vegetaPowerLevel.interpret(context));
        System.out.println("Vegeta's double power level: " + vegetaDoublePowerLevel.interpret(context));
        System.out.println("Goku's power level over 9000: " + gokuPlusThousand.interpret(context));

    }
}
