package com.five_philosophers;
//  cyclic one-left-directional enumerated list of forks
class SetOfForks {
    private volatile Fork currentFork;
//    int amountOfForks;

    SetOfForks() {
//        amountOfForks = 5;
        this.currentFork = new Fork(0);
        currentFork.setLeftFork(currentFork);
        for (int i = 1; i < 5; i++) {
//        for (int i = 1; i < amountOfForks; i++) {
            Fork nf = new Fork(i);
            nf.setLeftFork(currentFork.getLeftFork());
            currentFork.setLeftFork(nf);
        }
    }

    Fork getCurrentFork() {
        return currentFork;
    }       //  for future

    Fork leftAndGet() {
        currentFork = currentFork.getLeftFork();
        return currentFork;
    }

}
