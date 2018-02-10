package com.five_philosophers;

public class Philosopher extends Thread {
//  I think that nearly all parameters may be understandable by its names
    int myNumber;
    int timeForSpeech;
    int timeForEat;
    int timeForWait;            //  between attempt to take the forks
    int quantityOfApproaches;   //  quantity of plates with spaghetti
    Fork leftFork = null;
    Fork rightFork = null;
    boolean haveLeftFork;
    boolean haveRightFork;
    boolean isSpeaking;

    public Philosopher(int timeForSpeech, int timeForEat, int timeForWait, int quantityOfApproaches,boolean isSpeaking) {

        this.timeForSpeech = timeForSpeech;
        this.timeForEat = timeForEat;
        this.timeForWait = timeForWait;
        this.quantityOfApproaches = quantityOfApproaches;
        this.isSpeaking = isSpeaking;
    }

    void haveBanquet() throws InterruptedException {
        for (int i = 0; i < quantityOfApproaches; i++) {
            Sout.prnt(myNumber, "-" + i);
//          may be I want to speak a little
            if (isSpeaking)  Thread.sleep(timeForSpeech);
//          I had speaking and now I want to eat
            isSpeaking = false;
            int nT = 0;             //  for log printing
            while (true) {
                nT++;
                if (!leftFork.isBusy()) {//   If the leftFrork isn't busy I take it
                    leftFork.setBusy(true);
                    haveLeftFork = true;
                    if (!rightFork.isBusy()) {//  If the rightFork isn't busy I take it
                        rightFork.setBusy(true);
                        haveRightFork = true;
                        break;//    & I'll try enjoy by eat
                    } else {//  I put down leftFork if rightFork is busy
                        leftFork.setBusy(false);
                        haveLeftFork = false;
                    }
                }
//              wait a few till new attempt to take forks
                Thread.sleep(timeForWait);
            }
            Sout.prnt(myNumber, nT + "*" + i);
//          When I'm eating I'm not speaking & hearing
            isSpeaking = false;
//          It's wonderfull
            Thread.sleep(timeForEat);
//          After have a good food I'm don't against to speak
            isSpeaking = true;
//          I'll must return all forks
            leftFork.setBusy(false);
            rightFork.setBusy(false);
            haveLeftFork = false;
            haveRightFork = false;
//          & after returning forks I'll go to discuss
        }
    }
//  for debagging
    long currTime() {
        return System.currentTimeMillis();
    }


    @Override
    public void run() {
        Sout.prnt(myNumber, "Strt " + myNumber);
        try {
            haveBanquet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Sout.prnt(myNumber, "Finl " + myNumber);

    }
}
