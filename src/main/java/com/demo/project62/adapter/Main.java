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
    public void dracarys(String sector) {
        System.out.println("Firing weapon at sector " + sector);
    }

    public void zorg(String sector) {
        System.out.println("Scanning enemy in sector " + sector);
    }
}

class EnterpriseShip implements Ship {

    @Override
    public void scan() {
        System.out.println("Scanning enemy in front of ship!");
    }

    @Override
    public void fire() {
        System.out.println("Firing weapon!");
    }

}

@AllArgsConstructor
class SpaceShipAdapter implements Ship {
    AlienCraft ship;

    @Override
    public void scan() {
        ship.zorg("NORTH");
    }

    @Override
    public void fire() {
        ship.dracarys("NORTH");
    }

}