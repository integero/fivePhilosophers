package com.five_philosophers;

import java.util.HashSet;
import java.util.Set;

public class FiveOClock {
    Set<Philosopher> philosophers = new HashSet<>();
    volatile SetOfForks forks = new SetOfForks();

    public FiveOClock(int timeForSpeech, int timeForEat, int timeForWait, int quavolityOfApproachs, boolean isWaiting) {

        Philosopher tmpPH;
        Fork tmpF;
        for (int i = 0; i < forks.amountOfForks; i++) {
            tmpF = forks.leftAndGet();
            tmpPH = new Philosopher(timeForSpeech, timeForEat, timeForWait, quavolityOfApproachs, isWaiting);
            tmpPH.leftFork = tmpF.leftFork;
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