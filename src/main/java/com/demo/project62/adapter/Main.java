package com.demo.project62.adapter;

import lombok.AllArgsConstructor;

interface Ship {
    public void scan();

    public void fire();
}

public class Main {

    public static void main(String[] args) {
        SpaceShipAdapter shipAdapter = new SpaceShipAdapter(new AlienCraft());
        shipAdapter.scan();
        shipAdapter.fire();
    }
}

class AlienCraft {
    public void dracarys() {
        System.out.println("Firing weapon");
    }

    public void zorg() {
        System.out.println("Scanning enemy");
    }
}

@AllArgsConstructor
class SpaceShipAdapter implements Ship {
    AlienCraft ship;

    @Override
    public void scan() {
        ship.zorg();
    }

    @Override
    public void fire() {
        ship.dracarys();
    }

}