package ru.igorrodin.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MotorcycleTest {
    private Motorcycle motorcycle;

    @BeforeEach
    public void init() {
        motorcycle = new Motorcycle("Kawasaki", "NINJA® 650", 2024);
    }

    /**
     * Проверяет, что экземпляр класса Motorcycle является экземпляром класса Vehicle
     */
    @Test
    public void motorcycleShouldBeInstanceOfVehicle() {
        assertThat(motorcycle).isInstanceOf(Vehicle.class);
    }


    /**
     * Проверка того, объект Motorcycle создается с 2-мя колесами
     */
    @Test
    public void motorcycleShouldHaveFourWheels() {
        int numberOfWheels = motorcycle.getNumWheels();
        assertThat(numberOfWheels).isEqualTo(2);
    }

    /**
     * Проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения
     */
    @Test
    public void motorcycleShouldHaveSpeed60InTestDrive() {
        motorcycle.testDrive();
        int motorcycleSpeed = motorcycle.getSpeed();
        assertThat(motorcycleSpeed).isEqualTo(75);
    }

    /**
     * Проверка того, что в режиме парковки после testDrive мотоцикл
     * останавливается (speed = 0)
     */
    @Test
    public void motorcycleShouldHaveZeroSpeedInParkModeAfterTestDrive() {
        motorcycle.testDrive();
        motorcycle.park();
        int motorcycleSpeed = motorcycle.getSpeed();
        assertThat(motorcycleSpeed).isEqualTo(0);
    }
}
