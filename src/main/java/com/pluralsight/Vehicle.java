package com.pluralsight;

import java.time.LocalDate;
import java.time.Period;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;


    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        LocalDate currentDate = LocalDate.now();
        LocalDate acquisitionDate = LocalDate.parse(getDateAcquired());
        int yearsSinceAcquisition = Period.between(acquisitionDate, currentDate).getYears();

        double currentValue = this.originalCost;

        if (yearsSinceAcquisition >= 0 && yearsSinceAcquisition <= 3) {
            for (int i = 0; i < yearsSinceAcquisition; i++) {
                currentValue *= 0.97;
            }
        } else if (yearsSinceAcquisition >= 4 && yearsSinceAcquisition <= 6) {
            for (int i = 0; i < yearsSinceAcquisition; i++) {
                currentValue *= 0.94;
            }
        } else if (yearsSinceAcquisition >= 7 && yearsSinceAcquisition <= 10) {
            for (int i = 0; i < yearsSinceAcquisition; i++) {
                currentValue *= 0.92;
            }
        }else{
            currentValue -= 1000;
        }

        if (this.getOdometer() > 100000){
            currentValue *= 0.75;
        }
        return currentValue;
    }
}
