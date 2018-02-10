package com.five_philosophers;

public class Philosopher extends Thread {
    int myNumber;
    private int timeForSpeech;
    private int timeForEat;
    private int timeForWait;            //  between attempt to take the forks
    private int quantityOfApproaches;   //  quantity of plates with spaghetti
    Fork leftFork = null;
    Fork rightFork = null;

    Philosopher(int timeForSpeech, int timeForEat, int timeForWait, int quantityOfApproaches) {
        this.timeForSpeech = timeForSpeech;
        this.timeForEat = timeForEat;
        this.timeForWait = timeForWait;
        this.quantityOfApproaches = quantityOfApproaches;
    }

    private void haveBanquet() throws InterruptedException {
        for (int i = 0; i < quantityOfApproaches; i++) {
            Sout.prnt(myNumber, "-" + i);    //  monitoring of Ph
//          At first I must to eat & after discuss also
            int nT = 0;                             //  for log printing
            while (true) {
                nT++;
                if (!leftFork.isBusy()) {           //   If the leftFrork isn't busy I take it
                    leftFork.setBusy(true);
                    if (!rightFork.isBusy()) {      //  If the rightFork isn't busy I take it
                        rightFork.setBusy(true);
                        break;                      //    & I'll try enjoy by eat
                    } else {                        //  I put down leftFork if rightFork is busy
                        leftFork.setBusy(false);
                    }
                }
                Thread.sleep(timeForWait);          //  wait a few till new attempt to take forks
            }
            Sout.prnt(myNumber, nT + "*" + i);
            Thread.sleep(timeForEat);               //  When I'm eating I'm not speaking & hearing
            leftFork.setBusy(false);                //  I'll must return all forks
            rightFork.setBusy(false);
            Thread.sleep(timeForSpeech);            //  After have a good food I'm don't against to speak
        }
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
