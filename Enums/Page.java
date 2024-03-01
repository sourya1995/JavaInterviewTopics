package Enums;

import java.util.EnumSet;

enum Page {
    A1, A2, A3, A4, A5, A6, A7, A8, A9, A10;

    public static void main(String[] args) {
        EnumSet<Page> range = EnumSet.range(Page.A1, Page.A10);
        for (Page p : range) {
            System.out.println(p);
        }

        EnumSet<Page> range2 = EnumSet.of(Page.A1, Page.A5);
        if (range2.contains(Page.A1)) {
            System.out.println("A1 is in the set");
        }
    }
}
