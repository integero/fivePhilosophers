package com.five_philosophers;

public class SetOfForks {
    volatile Fork currentFork;
    public int amountOfForks;

    public SetOfForks() {
        this.currentFork = new Fork();
        currentFork.leftFork = currentFork;
        currentFork.myNumber = 0;
        amountOfForks = 5;
        for (int i = 1; i < 5; i++) {
            Fork nf = new Fork();
            nf.leftFork = currentFork.leftFork;
            nf.myNumber = i;
            currentFork.leftFork = nf;
        }
    }

    Fork getCurrentFork() {
        return currentFork;
    }

    Fork leftAndGet() {
        currentFork = currentFork.leftFork;
        return currentFork;
    }

}
