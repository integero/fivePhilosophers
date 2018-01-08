package five_philosofers;

public class Main {
    public static void main(String[] args) {
        SetOfForks setOfForks = new SetOfForks();
        for (int i = 0; i < 5; i++) {
            setOfForks.addFork();
        }
        FiveOClock fiveOClock = new FiveOClock();
        fiveOClock.invitation(setOfForks);
        fiveOClock.startBanquet();

    }
}
