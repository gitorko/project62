package com.demo.project62.flyweight;

import java.util.HashMap;
import java.util.Random;

import lombok.AllArgsConstructor;

enum BeeType {
    WORKER, WORKER_LEADER, ATTACKER, ATTACKER_LEADER;

    public static BeeType getRandom(int val) {
        return BeeType.values()[val];
    }
}

interface Bee {
    public void carryOutMission(int x, int y);
}

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            Bee b = FlyweightBeeFactory.getBeeType(BeeType.getRandom(new Random().nextInt(4)));
            b.carryOutMission(new Random().nextInt(100), new Random().nextInt(100));
        }

        System.out.println("Total Bee objects created:" + FlyweightBeeFactory.bees.size());
    }
}

@AllArgsConstructor
class WorkerBee implements Bee {

    BeeType beeType;

    @Override
    public void carryOutMission(int x, int y) {
        System.out.println(beeType + ", Depositing honey at (" + x + "," + y + ") quadrant!");
    }

}

@AllArgsConstructor
class AttackBee implements Bee {

    BeeType beeType;

    @Override
    public void carryOutMission(int x, int y) {
        System.out.println(beeType + ", Defending (" + x + "," + y + ") quadrant!");
    }

}

class FlyweightBeeFactory {

    public static final HashMap<BeeType, Bee> bees = new HashMap<>();

    public static Bee getBeeType(BeeType beeType) {
        Bee bee = bees.get(beeType);
        if (bee == null) {
            if (beeType.equals(BeeType.WORKER)) {
                bee = new WorkerBee(BeeType.WORKER);
            } else if (beeType.equals(BeeType.WORKER_LEADER)) {
                bee = new WorkerBee(BeeType.WORKER_LEADER);
            } else if (beeType.equals(BeeType.ATTACKER_LEADER)) {
                bee = new WorkerBee(BeeType.ATTACKER_LEADER);
            } else {
                bee = new WorkerBee(BeeType.ATTACKER);
            }
            bees.put(beeType, bee);
        }
        return bee;
    }

}
