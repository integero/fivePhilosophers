package com.five_philosophers;

class Fork {
    private Fork leftFork;
    private int myNumber;
    private boolean isBusy;

    public Fork(int myNumber) {
        this.myNumber = myNumber;
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public Fork getLeftFork() {
        return leftFork;
    }

    public int getMyNumber() {
        return myNumber;
    }

    public boolean isBusy() {
        return isBusy;
    }
}

