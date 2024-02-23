package Strings;
import java.util.Scanner;

public class ChangeCaseOfOneCharacter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string");
        String inputString = input.next();
        char[] characterArray = inputString.toCharArray();
        System.out.println("Enter the character");
        String character = input.next();
        char characterToChange = character.charAt(0);

        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i] == characterToChange) {
                if (characterToChange >= 'a' && characterToChange <= 'z') {
                    characterToChange -= 32;
                }

                else if (characterToChange >= 'A' && characterToChange <= 'Z') {
                    characterToChange += 32;
                }
                characterArray[i] = characterToChange;
                break;
            }
        }

        inputString = String.valueOf(characterArray); // convert character array to String
        System.out.println(inputString);

    }
}
