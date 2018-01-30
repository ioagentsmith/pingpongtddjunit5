package com.bbd.pingpong;

import java.util.ArrayList;
import java.util.List;

public class RomanConverter {

    public static int Convert(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid Numeral");
        }

        s = s.toUpperCase();
        int sum = 0;


        for (int i = 0; i < s.length(); i++) {


            if (s.charAt(i) == 'I') {
                sum++;
            } else if (s.charAt(i) == 'V') {
                sum += 5;
            } else if (s.charAt(i) == 'X') {
                sum = handleNumeral(s, sum, "X", 10);
            } else if (s.charAt(i) == 'L') {
                sum = handleNumeral(s, sum, "L", 50);
            } else if (s.charAt(i) == 'C') {
                sum = handleNumeral(s, sum, "C", 100);
            } else if (s.charAt(i) == 'D') {
                sum = handleNumeral(s, sum, "D", 500);
            } else if (s.charAt(i) == 'M') {
                sum = handleNumeral(s, sum, "D", 1000);
            } else {
                throw new IllegalArgumentException("Invalid Numeral");
            }

            //Numerals.valueOf(s.charAt(i));
        }

        return Math.abs(sum);
    }

    private static int handleNumeral(final String s, int sum, final String numeral, final int value) {
        if (s.endsWith(numeral)) {
            sum -= value;
        } else {
            sum += value;
        }
        return sum;
    }
}

enum Numerals {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    public int value;

    Numerals(int value) {
        this.value = value;
    }

}