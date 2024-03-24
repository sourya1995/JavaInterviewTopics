package RandomGeneration;

public class RandomNumbersNoDup {

    public static int[] getRandomNumbersWithNoDuplicates(int range, int length) {
        if (length < range) {
            int[] randomNumbers = new int[length];
            for (int q = 0; q < randomNumbers.length; q++) {
                int remainingNumbers = range - q;
                int randomNumber = (int) (Math.random() * remainingNumbers);
                randomNumber++;
                for (int t = 1; t < range + 1; t++) {
                    boolean taken = false;
                    for (int number : randomNumbers) {
                        if (t == number) {
                            taken = true;
                            break;
                        }
                    }
                    if (!taken) {
                        randomNumber--;
                        if (randomNumber == 0) {
                            randomNumbers[q] = t;
                        }
                    }

                }
            }
            return randomNumbers;
        } else {
            //whatever
        }
        return null;
    }
}
