package org.example;

class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        expectedEndingValue = getVehicleSold().getPrice()/2;
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        leaseFee = 0.07 * getVehicleSold().getPrice();
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return leaseFee + getVehicleSold().getPrice();
    }

    @Override
    public double getMonthlyPayment() {
        double num1 = expectedEndingValue/36;
        double num2 = ((double) 4 /2400);
        double num3 = (expectedEndingValue + getVehicleSold().getPrice()) * num2;
        double leasemonth = leaseFee / 36;
        return num1 + num3 + leasemonth;

    }
}