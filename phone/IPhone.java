package com.phone;

public class IPhone extends Phone implements Ringable {
    String c = this.getClass().getSimpleName();

    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return String.format("%s %s says %s", this.c, this.getVersionNumber, this.getRingTone());
    }

    @Override
    public String unlock() {
        return "Unlocking via facial recognition";
    }

    @Override
    public void displayInfo() {
        System.out.println(String.format("%s %s from %s", this.c, this.getVersionNumber(), this.getCarrier()));
    }
}
