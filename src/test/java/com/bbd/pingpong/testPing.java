package com.bbd.pingpong;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class testPing {

    //ufkholvadia@gmail.com - Umar

    @ParameterizedTest
    @CsvSource(
            {
            "I, 1",
            "II, 2",
            "V, 5",
            "VI, 6",
            "vi, 6",
            "VIII, 8",
            "IX, 9",
            "X, 10",
            "XI, 11",
            "XIX, 19",
            "XX, 20",
            "XXX, 30",
            "XL, 40",
            "XC, 90",
            "C, 100",
            "D, 500",
            "M, 1000"
    })
    public void testConverter(String numeral, int value) {
        assertEquals(value, RomanConverter.Convert(numeral));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "b", "null"})
    public void testException(String numeral) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanConverter.Convert(numeral);
        });
        assertEquals("Invalid Numeral", exception.getMessage());
    }

    @Test
    public void testNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanConverter.Convert(null);
        });
        assertEquals("Invalid Numeral", exception.getMessage());
    }

}