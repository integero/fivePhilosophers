package com.five_philosophers;

import java.util.HashSet;
import java.util.Set;

public class FiveOClock {
    Set<Philosopher> philosophers = new HashSet<>();
    volatile SetOfForks forks = new SetOfForks();

    public FiveOClock(int timeForSpeech, int timeForEat, int timeForWait, int quantityOfApproachs, boolean isWaiting) {

        Philosopher tmpPH;
        Fork tmpF;
        for (int i = 0; i < 5; i++) {
            tmpF = forks.leftAndGet();
            tmpPH = new Philosopher(timeForSpeech, timeForEat, timeForWait, quantityOfApproachs, isWaiting);
            tmpPH.leftFork = tmpF.getLeftFork();
            tmpPH.rightFork = tmpF;
            tmpPH.myNumber = i;
            philosophers.add(tmpPH);
        }
        for (Philosopher ph : philosophers) {
//          For each philosopher - personal Thread
            ph.start();
        }
    }

}