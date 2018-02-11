package com.five_philosophers;

class Fork {
    private Fork leftFork;
    private int myNumber;       //  isn't necessary but let it be for future
    private boolean isBusy;

    Fork(int myNumber) {
        this.myNumber = myNumber;
    }

    void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    void setBusy(boolean busy) {
        isBusy = busy;
    }

    Fork getLeftFork() {
        return leftFork;
    }

    boolean isBusy() {
        return isBusy;
    }
}

