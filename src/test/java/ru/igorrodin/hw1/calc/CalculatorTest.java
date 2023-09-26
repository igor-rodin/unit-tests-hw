package ru.igorrodin.hw1.calc;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    @Test
    public void testDiscount() {
        BigDecimal expectedPrice = BigDecimal.valueOf(1050);
        BigDecimal actualPrice = Calculator.calculateDiscount(BigDecimal.valueOf(1000), 5);
        assertThat(actualPrice).isEqualByComparingTo(expectedPrice);
    }

    @Test
    public void notValidPriceShouldThrowArithmeticException() {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
            BigDecimal priceWithDiscount = Calculator.calculateDiscount(BigDecimal.valueOf(-100), 5);
        }).withMessageContaining("Стоимость заказа");
    }

    @Test
    public void notValidDiscountShouldThrowArithmeticException() {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
            BigDecimal priceWithDiscount = Calculator.calculateDiscount(BigDecimal.valueOf(100), 120);
        }).withMessageContaining("Величина скидки");
    }
}
