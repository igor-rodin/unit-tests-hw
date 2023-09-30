package ru.igorrodin.hw2;

import java.text.MessageFormat;

public class Motorcycle extends Vehicle {

    public Motorcycle(String company, String model, int year) {
        this.company = company;
        this.model = model;
        this.yearRelease = year;
        this.numWheels = 2;
        this.speed = 0;
    }

    @Override
    public void testDrive() {
        this.speed = 75;
    }

    @Override
    public void park() {
        this.speed = 0;
    }

    @Override
    public String toString() {
        return MessageFormat.format("This Motorcycle is a {0} make, model {1};", yearRelease, model);
    }
}
