package ru.igorrodin.hw3;

public class NumberOperationsClass {
    public static boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод проверяет, входит ли число n в интервал (25, 100), не включая границы интервала
     *
     * @param n
     * @return true, если входит
     */
    public static boolean numberInInterval(int n) {
        int LOW_VALUE = 25;
        int UP_VALUE = 100;
        return n > LOW_VALUE && n < UP_VALUE;
    }

}
