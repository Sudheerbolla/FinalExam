package com.finalexam;

public class Savings {

    private String customerName, customerNumber, typeOfSaving;
    private int noOfYears;
    private double initialDeposit;

    public Savings(String customerName, String customerNumber, String typeOfSaving, int noOfYears, double initialDeposit) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.typeOfSaving = typeOfSaving;
        this.noOfYears = noOfYears;
        this.initialDeposit = initialDeposit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getTypeOfSaving() {
        return typeOfSaving;
    }

    public void setTypeOfSaving(String typeOfSaving) {
        this.typeOfSaving = typeOfSaving;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

}
