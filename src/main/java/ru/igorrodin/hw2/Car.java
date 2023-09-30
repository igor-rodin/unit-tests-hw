package ru.igorrodin.hw2;

import java.text.MessageFormat;

public class Car extends Vehicle {
    public Car(String company, String model, int year) {
        this.company = company;
        this.model = model;
        this.yearRelease = year;
        this.numWheels = 4;
        this.speed = 0;
    }

    @Override
    public void testDrive() {
        this.speed = 60;
    }

    @Override
    public void park() {
        this.speed = 0;
    }

    @Override
    public String toString() {
        return MessageFormat.format("This car is a {0} make, model {1};", yearRelease, model);
    }
}
