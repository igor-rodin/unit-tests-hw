package ru.igorrodin.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOperationsClassTest {

    @ParameterizedTest
    @CsvSource({"false, 5", "true, 6"})
    @DisplayName("Проверяет число на четность")
    void numberShouldBeOdd(boolean expectedValue, int num) {
        assertThat(NumberOperationsClass.evenOddNumber(num)).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @DisplayName("Проверяет вхождение числа в диапазон (25, 100) не включая границы")
    @CsvSource({"false, -20", "true, 50", "false, 25", "false, 100", "false, 120"})
    void testNumberInInterval(boolean expectedValue, int number) {
        assertThat(NumberOperationsClass.numberInInterval(number)).isEqualTo(expectedValue);
    }
}