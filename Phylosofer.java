package five_philosofers;

public class Phylosofer extends Thread{
//public class Phylosofer implements Runnable {
    int myNumber;
    int timeForSpeech;
    int timeForEat;
    int quantityOfApproaches;
    Fork leftFork = null;
    boolean takeLeftFork;
    Fork rightFork = null;
    boolean takeRightFork;
    boolean isSpeaking;
    boolean isEating;
    boolean isWaiting;

    public Phylosofer(int timeForSpeech, int timeForEat, int quantityOfApproaches, boolean isWaiting) {
        this.timeForSpeech = timeForSpeech;
        this.timeForEat = timeForEat;
        this.quantityOfApproaches = quantityOfApproaches;
        if (isWaiting) {
            isEating = false;
            isEating = false;
        } else {
            isEating = false;
            isSpeaking = true;
        }
    }

    void haveBanquet() throws InterruptedException {
        for (int i = 0; i < quantityOfApproaches; i++) {
            Sout.prnt(myNumber,"-"+i+"-"+myNumber);
            if (isSpeaking)
                Thread.sleep(timeForSpeech);
            isWaiting = true;
            isSpeaking = false;
            long timeLimitLeft = 0;
            long timeLimitRight = 0;
            int nT = 0;
            while (true) {
                nT++;
                if (!leftFork.isBusy) {
                    leftFork.isBusy = true;
                    takeLeftFork = true;
                    timeLimitLeft = currTime() + timeForEat / 100;
                } else if (takeLeftFork  && (currTime() > timeLimitLeft)) {
                    leftFork.isBusy = false;
                    takeLeftFork = false;
                }
                if (!rightFork.isBusy) {
                    rightFork.isBusy = true;
                    takeRightFork = true;
                    timeLimitRight = currTime() + timeForEat / 100;
                } else if (takeRightFork && (currTime() > timeLimitRight)) {
                    rightFork.isBusy = false;
                    takeRightFork= false;
                }
                if (takeLeftFork&&takeRightFork) break;
                Thread.sleep(timeForEat);

                leftFork.isBusy = false;
                takeLeftFork = false;
                rightFork.isBusy = false;
                takeRightFork= false;
            }
            Sout.prnt(myNumber,"*"+i+"*"+myNumber+" "+nT );

            Thread.sleep(timeForSpeech);
        }
    }

    long currTime() {
        return System.currentTimeMillis();
    }

    void seizure() {

    }

    @Override
    public void run() {
        Sout.prnt(myNumber,"Str "+myNumber);
        try {
            haveBanquet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Sout.prnt(myNumber,"Fin "+myNumber);

    }

































}
