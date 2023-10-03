package ru.igorrodin.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOperationsClassTest {

    @Test
    @DisplayName("Проверяет число на нечетность")
    void numberShouldBeOdd() {
        assertThat(NumberOperationsClass.evenOddNumber(5)).isFalse();
    }

    @Test
    @DisplayName("Проверяет число на четность")
    void numberShouldBeEven() {
        assertThat(NumberOperationsClass.evenOddNumber(6)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Проверяет вхождение числа в диапазон (25, 100) не включая границы")
    @CsvSource(quoteCharacter = '"', textBlock = """
            "false", 1
            "true", 50
            "false", 25
            "false", 100
            "false", 120
            """)
    void testNumberInInterval(String expectedValue, String numStr) {
        boolean expected = Boolean.parseBoolean(expectedValue);
        int num = Integer.parseInt(numStr);
        assertThat(NumberOperationsClass.numberInInterval(num)).isEqualTo(expected);
    }
}