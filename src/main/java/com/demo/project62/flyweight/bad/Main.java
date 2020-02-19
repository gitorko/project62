package com.demo.project62.flyweight.bad;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

enum BeeType {
    WORKER, ATTACKER;
    public static BeeType getRandom() {
        //Returns random bee types.
        return BeeType.values()[new Random().nextInt(2)];
    }
}

interface Bee {
    public void carryOutMission(int x, int y);
}

public class Main {

    public static void main(String[] args) {
        int i = 0;
        for (; i < 100000; i++) {
            int posx =  new Random().nextInt(10);
            int posy =  new Random().nextInt(10);
            BeeType type = BeeType.getRandom();
            if(type.equals(BeeType.WORKER)) {
                new WorkerBee(BeeType.getRandom()).carryOutMission(posx,posy);
            } else {
                new AttackBee(BeeType.getRandom()).carryOutMission(posx,posy);
            }

        }
        System.out.println("Total Bee objects created:" + i);
    }
}

class WorkerBee implements Bee {

    BeeType beeType;

    @SneakyThrows
    public WorkerBee(BeeType beeType) {
        //Takes long time
        TimeUnit.SECONDS.sleep(1);
        this.beeType = beeType;
    }

    @Override
    public void carryOutMission(int x, int y) {
        System.out.println(beeType + ", Depositing honey at (" + x + "," + y + ") quadrant!");
    }

}

class AttackBee implements Bee {

    BeeType beeType;

    @SneakyThrows
    public AttackBee(BeeType beeType) {
        //Takes long time
        TimeUnit.SECONDS.sleep(1);
        this.beeType = beeType;
    }

    @Override
    public void carryOutMission(int x, int y) {
        System.out.println(beeType + ", Defending (" + x + "," + y + ") quadrant!");
    }

}
