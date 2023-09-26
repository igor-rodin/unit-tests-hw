package ru.igorrodin.hw1.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;

public class Calculator {

    public static final int MIN_DISCOUNT = 0;
    public static final int MAX_DISCOUNT = 100;
    public static final String WRONG_PRICE_MESSAGE = "Стоимость заказа должна быть положительным числом";
    public static final String WRONG_DISCOUNT_MESSAGE = MessageFormat.format("Величина скидки не может быть меньше {0} или больше {1}", MIN_DISCOUNT, MAX_DISCOUNT);

    public static BigDecimal calculateDiscount(BigDecimal orderPrice, int discount) {
        if (orderPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ArithmeticException(WRONG_PRICE_MESSAGE);
        }

        if (discount < MIN_DISCOUNT || discount > MAX_DISCOUNT) {
            throw new ArithmeticException(WRONG_DISCOUNT_MESSAGE);
        }
        return orderPrice
                .multiply(BigDecimal.ONE.add((BigDecimal.valueOf(discount).multiply(BigDecimal.valueOf(0.01)))));
    }
}
