package com.demo.project62.flyweight;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

//divide Object property into intrinsic and extrinsic properties
enum BeeType {
    WORKER, ATTACKER;
    public static BeeType getRandom() {
        return BeeType.values()[new Random().nextInt(2)];
    }
}

interface Bee {
    public void carryOutMission(int x, int y);
}

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int posx = new Random().nextInt(10);
            int posy = new Random().nextInt(10);
            FlyweightBeeFactory.getBeeType(BeeType.getRandom()).carryOutMission(posx, posy);
        }
        System.out.println("Total Bee objects created:" + FlyweightBeeFactory.bees.size());
    }
}

class WorkerBee implements Bee {

    @SneakyThrows
    public WorkerBee() {
        //Takes long time
        System.out.println("Creating worker bee!");
        TimeUnit.SECONDS.sleep(1);
    }

    @Override
    public void carryOutMission(int x, int y) {
        System.out.println("Depositing honey at (" + x + "," + y + ") quadrant!");
    }

}

class AttackBee implements Bee {

    @SneakyThrows
    public AttackBee() {
        //Takes long time
        System.out.println("Creating attack bee!");
        TimeUnit.SECONDS.sleep(1);
    }

    @Override
    public void carryOutMission(int x, int y) {
        System.out.println("Defending (" + x + "," + y + ") quadrant!");
    }

}

class FlyweightBeeFactory {

    public static final HashMap<BeeType, Bee> bees = new HashMap<>();

    public static Bee getBeeType(BeeType beeType) {
        Bee bee = bees.get(beeType);
        if (bee == null) {
            if (beeType.equals(BeeType.WORKER)) {
                bee = new WorkerBee();
            } else {
                bee = new AttackBee();
            }
            bees.put(beeType, bee);
        }
        return bee;
    }

}
