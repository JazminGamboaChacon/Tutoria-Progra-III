package com.wiki.Bridge;

class RemoteControl {
    protected Device device;


    public RemoteControl( ) {
    }

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }
}
