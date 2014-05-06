package com.mdrabic.viewholderperformance.app;

import java.util.ArrayList;
import java.util.List;

public class DogeContent {

    public static List<Doge> ITEMS = new ArrayList<Doge>();

    static {
        for (int i = 0; i < 10000; i++)
            addDogeItem();
    }

    private static void addItem(Doge item) {
        ITEMS.add(item);
    }

    private static void addDogeItem() {
        addItem(new Doge("Doge ", "Doge "));
    }

    public static class Doge {
        private String textOne;
        private String textTwo;

        public Doge(String textOne, String textTwo) {
            this.textOne = textOne;
            this.textTwo = textTwo;
        }

        public String getTextOne() {
            return textOne;
        }

        public String getTextTwo() {
            return textTwo;
        }

        @Override
        public String toString() {
            return textOne + " " + textTwo;
        }
    }
}
