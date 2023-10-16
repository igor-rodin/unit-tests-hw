"""
Модуль CalcAvg
"""


class CalcCompareAvgError(Exception):
    """
    Исключение выбрасываемое при некорректных входных данных метода  compare_avg_arr
    """

    def __init__(self, message="Один или оба входных параметра либо не являются списком, "
                               "либо являются пустыми"):
        self.message = message
        super().__init__(self.message)


class CalcAvg:
    """
    Содержит статические методы для нахождения и сравнения средних значений списков
    """

    @staticmethod
    def compare_avg_arr(arr1: list[float | int], arr2: list[float | int]) \
            -> str | CalcCompareAvgError:
        """
        Сравнивает средние значения двух списков чисел
        :param arr1: Список чисел
        :param arr2: Список чисел
        :return: 'Первый список имеет большее среднее значение',
                если среднее значение первого списка больше.
                'Второй список имеет большее среднее значение'
                если среднее значение второго списка больше.
                'Средние значения равны', если средние значения списков равны.
                Бросает исключение CalcCompareAvgError, при некорректных параметрах.
        """

        first_greater_second = "Первый список имеет большее среднее значение"
        second_greater_first = "Второй список имеет большее среднее значение"
        first_equal_second = "Средние значения равны"

        try:
            avg1 = CalcAvg.avg(arr1)
            avg2 = CalcAvg.avg(arr2)
            if avg1 > avg2:
                return first_greater_second
            if avg2 > avg1:
                return second_greater_first
            return first_equal_second

        except (TypeError, ValueError) as ex:
            raise CalcCompareAvgError from ex

    @staticmethod
    def avg(arr: list[float | int]) -> float:
        """
        Рассчитывает среднее значение списка чисел
        :param arr:Список чисел
        :return: Среднее значение
        """
        if not isinstance(arr, list):
            raise TypeError("The input should be a list.")
        if not arr:
            raise ValueError("The input cannot be empty")

        return sum(arr) / len(arr)
