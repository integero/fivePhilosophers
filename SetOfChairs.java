package five_philosofers;

public class SetOfChairs {
    Chair currentChair;

    public SetOfChairs(SetOfForks forks) {
        currentChair = new Chair();
        Chair tmpChair = currentChair;
        for (int i = 1; i < forks.amountOfForks; i++) {
            currentChair.leftChair = new Chair();
            currentChair = currentChair.leftChair;
        }
        currentChair.leftChair = tmpChair;

        Fork tmpFork=forks.currentFork;
        for (int i = 0; i < forks.amountOfForks; i++) {
            currentChair.rightFork = tmpFork;
            currentChair.leftFork = tmpFork.leftFork;
            currentChair = currentChair.leftChair;
            tmpFork = tmpFork.leftFork;
        }
    }
}
