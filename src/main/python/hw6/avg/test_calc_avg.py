"""
Модуль с тестами
"""
import pytest

from .avg_array import CalcAvg, CalcCompareAvgError


class TestCalcAvg:
    """
    Тестовый класс для тестирования методов класса CalcAvg
    """

    @pytest.mark.parametrize(("expected", "arr"),
                             [(4.5, [6, 3, 4, 5]),
                              (2, [2])])
    def test_avg(self, expected, arr):
        """
        Проверяет, что метод CalcAvg.avg работает корректно с корректными данными
        :param expected: Ожидаемое среднее значение
        :param arr: Массив чисел
        :return:
        """
        assert expected == pytest.approx(CalcAvg.avg(arr))

    def test_avg_raise_value_error(self):
        """
        Проверяет, что avg выбрасывает исключение
        ValueError если на входе пустой список
        :return:
        """
        with pytest.raises(ValueError) as error:
            CalcAvg.avg([])
        assert "The input cannot be empty" in str(error.value)

    def test_avg_raise_type_error(self):
        """
        Проверяет, что avg выбрасывает исключение
        TypeError если на входе не список
        :return:
        """
        with pytest.raises(TypeError) as error:
            CalcAvg.avg("arr")
        assert "The input should be a list." in str(error.value)

    first_greater_second = "Первый список имеет большее среднее значение"
    second_greater_first = "Второй список имеет большее среднее значение"
    first_equal_second = "Средние значения равны"

    @pytest.mark.parametrize(("expected", "arr1", "arr2"),
                             [(first_greater_second, [6, 3, 4, 5], [3, -2, 5]),
                              (second_greater_first, [3, -2, 5], [6, 3, 4, 5]),
                              (first_equal_second, [3, -2, 5], [2, 2, 2])])
    def test_compare_avg_arr(self, expected, arr1, arr2):
        """
        Проверяет, что метод compare_avg_arr работает корректно с корректными данными
        :param expected: Ожидаемое значение
        :param arr1: Первый массив чисел
        :param arr2: Второй массив чисел
        :return:
        """

        assert CalcAvg.compare_avg_arr(arr1, arr2) == expected

    def test_compare_avg_arr_raise_calc_compare_avg_error(self):
        """
        Проверяет, что compare_avg_arr выбрасывает исключение
        CalcCompareAvgError при некорректных входных данных
        :return:
        """

        error_msg = "Один или оба входных параметра либо не являются списком, либо являются пустыми"
        with pytest.raises(CalcCompareAvgError) as error:
            CalcAvg.compare_avg_arr("arr1", [1, 4, 3.8])
        assert error_msg in str(error.value)

        with pytest.raises(CalcCompareAvgError) as error:
            CalcAvg.compare_avg_arr([0, -4, 2.1], [])
        assert error_msg in str(error.value)
