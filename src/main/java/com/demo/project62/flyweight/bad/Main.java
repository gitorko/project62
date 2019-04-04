package com.demo.project62.flyweight.bad;

import java.util.Random;

import lombok.AllArgsConstructor;

enum BeeType {
    WORKER, WORKER_LEADER, ATTACKER, ATTACKER_LEADER;

    public static BeeType getRandom(int val) {
        return BeeType.values()[val];
    }
}

interface Bee {
    public void carryOutMission();
}

public class Main {

    public static void main(String[] args) {
        int i = 0;
        for (; i < 100000; i++) {
            BeeType beeType = BeeType.getRandom(new Random().nextInt(4));
            if (beeType.equals(BeeType.WORKER)) {
                new WorkerBee(BeeType.WORKER, new Random().nextInt(100), new Random().nextInt(100)).carryOutMission();
            } else if (beeType.equals(BeeType.WORKER_LEADER)) {
                new WorkerBee(BeeType.WORKER_LEADER, new Random().nextInt(100), new Random().nextInt(100)).carryOutMission();
            } else if (beeType.equals(BeeType.ATTACKER_LEADER)) {
                new WorkerBee(BeeType.ATTACKER_LEADER, new Random().nextInt(100), new Random().nextInt(100)).carryOutMission();
            } else {
                new WorkerBee(BeeType.ATTACKER, new Random().nextInt(100), new Random().nextInt(100)).carryOutMission();
            }
        }
        System.out.println("Total Bee objects created:" + i);
    }
}

@AllArgsConstructor
class WorkerBee implements Bee {

    BeeType beeType;
    int x;
    int y;

    @Override
    public void carryOutMission() {
        System.out.println(beeType + ", Depositing honey at (" + x + "," + y + ") quadrant!");
    }

}

@AllArgsConstructor
class AttackBee implements Bee {

    BeeType beeType;
    int x;
    int y;

    @Override
    public void carryOutMission() {
        System.out.println(beeType + ", Defending (" + x + "," + y + ") quadrant!");
    }

}
