"""
Главный модуль
"""
from avg import CalcAvg, CalcCompareAvgError


def run():
    """
    Точка запуска приложения
    :return:
    """
    try:
        res = CalcAvg.compare_avg_arr([3, 2], [4, 6])
        print(res)
    except CalcCompareAvgError as e:
        print(e)


if __name__ == "__main__":
    run()
