package ru.igorrodin.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    private Car car;

    @BeforeEach
    public void init() {
        car = new Car("Renault", "Kaptur", 2016);
    }

    /**
     * Проверяет, что экземпляр класса Car является экземпляром класса Vehicle
     */
    @Test
    public void carShouldBeInstanceOfVehicle() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }


    /**
     * Проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    public void carShouldHaveFourWheels() {
        int numberOfWheels = car.getNumWheels();
        assertThat(numberOfWheels).isEqualTo(4);
    }

    /**
     * Проверка того, объект Car развивает скорость 60 в режиме тестового вождения
     */
    @Test
    public void carShouldHaveSpeed60InTestDrive() {
        car.testDrive();
        int carSpeed = car.getSpeed();
        assertThat(carSpeed).isEqualTo(60);
    }

    /**
     * Проверка того, что в режиме парковки после testDrive машина
     * останавливается (speed = 0)
     */
    @Test
    public void carShouldHaveZeroSpeedInParkModeAfterTestDrive() {
        car.testDrive();
        car.park();
        int carSpeed = car.getSpeed();
        assertThat(carSpeed).isEqualTo(0);
    }
}
