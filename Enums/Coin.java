package Enums;

public enum Coin {
    PENNY(1, true), NICKEL(5, false), DIME(10), QUARTER(25);

    private final int value;
    private final boolean isCopperColored;

    Coin(int value) {
        this(value, false);
    }

    

    private Coin(int value, boolean isCopperColored) {
        this.value = value;
        this.isCopperColored = isCopperColored;
    }



    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        int p = Coin.PENNY.getValue();
        int n = Coin.NICKEL.getValue();
        int d = Coin.DIME.getValue();
    }
}
