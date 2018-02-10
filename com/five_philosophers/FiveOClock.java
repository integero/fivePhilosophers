package com.five_philosophers;

import java.util.HashSet;
import java.util.Set;

class FiveOClock {
    private Set<Philosopher> philosophers = new HashSet<>();
    private volatile SetOfForks forks = new SetOfForks();

    FiveOClock(int timeForSpeech, int timeForEat, int timeForWait, int quantityOfApproachs, boolean isSpeaking) {

        Philosopher tmpPH;
        Fork tmpF;
        for (int i = 0; i < 5; i++) {
            tmpF = forks.leftAndGet();
            tmpPH = new Philosopher(timeForSpeech, timeForEat, timeForWait, quantityOfApproachs, isSpeaking);
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