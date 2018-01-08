package five_philosofers;

public class SetOfForks {
    Fork currentFork;
    public int amountOfForks;

    public SetOfForks() {
        this.currentFork = new Fork();
        currentFork.myNumber = 0;
        currentFork.leftFork = currentFork;
        currentFork.rightFork = currentFork;
        amountOfForks = 1;
    }

    void addFork() {
        Fork nf = new Fork();
        nf.myNumber = amountOfForks;
        amountOfForks++;
        nf.leftFork = currentFork.leftFork;
        nf.rightFork = currentFork;
        currentFork.leftFork = nf;
        nf.leftFork.rightFork = nf;
    }

    Fork getCurrentFork() {
        return currentFork;
    }

    Fork leftAndGet() {
        currentFork = currentFork.leftFork;
        return currentFork;
    }

    Fork rightAndGet() {
        currentFork = currentFork.rightFork;
        return currentFork;
    }
}
