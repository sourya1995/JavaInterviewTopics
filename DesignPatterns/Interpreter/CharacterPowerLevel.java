package DesignPatterns.Interpreter;

public class CharacterPowerLevel implements PowerLevelExpression {

    private String character;

    public CharacterPowerLevel(String character) {
        this.character = character;
    }


    @Override
    public int interpret(PowerLevelContext context) {
       return context.getPowerLevel(character);
    }
    
}
