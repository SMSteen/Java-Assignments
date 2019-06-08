package com.phone;

public class Galaxy extends Phone implements Ringable {
    String c = this.getClass().getSimpleName();

    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return String.format("%s %s says %s", this.c, this.getVersionNumber(), this.getRingTone());
    }

    @Override
    public String unlock() {
        return "Unlocking via finger print";
    }

    @Override
    public void displayInfo() {
        System.out.println(String.format("%s %s from %s", this.c, this.getVersionNumber(), this.getCarrier()));
    }

}
