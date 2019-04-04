package com.demo.project62.bridge.other;

import lombok.AllArgsConstructor;

interface ElectricDevice {
    public void doSomething();
}

public class Main {

    public static void main(String[] args) {
        Switch switch1 = new PullSwitch(new Light());
        switch1.toggle();
        System.out.println("----------------");
        Switch switch2 = new PressSwitch(new Fan());
        switch2.toggle();
    }

}

class Fan implements ElectricDevice {

    @Override
    public void doSomething() {
        System.out.println("Fan!");
    }
}

class Light implements ElectricDevice {

    @Override
    public void doSomething() {
        System.out.println("Light!");
    }
}

@AllArgsConstructor
abstract class Switch {

    protected ElectricDevice eDevice;

    public abstract void toggle();
}

class PressSwitch extends Switch {

    boolean state;

    public PressSwitch(ElectricDevice d) {
        super(d);
    }

    @Override
    public void toggle() {
        if (state) {
            System.out.print("Pressed Switch, Now turning off :");
            eDevice.doSomething();
            state = Boolean.FALSE;
        } else {
            System.out.print("Pressed Switch, Now turning on :");
            eDevice.doSomething();
            state = Boolean.TRUE;
        }
    }
}

class PullSwitch extends Switch {

    boolean state;

    public PullSwitch(ElectricDevice d) {
        super(d);
    }

    @Override
    public void toggle() {
        if (state) {
            System.out.print("Pulled Switch, Now turning off :");
            eDevice.doSomething();
            state = Boolean.FALSE;
        } else {
            System.out.print("Pulled Switch, Now turning on :");
            eDevice.doSomething();
            state = Boolean.TRUE;
        }
    }
}
