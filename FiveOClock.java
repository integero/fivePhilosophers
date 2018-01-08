package five_philosofers;

import java.util.HashSet;
import java.util.Set;

public class FiveOClock {
    Set<Phylosofer> phylosofers = new HashSet<>();

    void invitation(SetOfForks forks) {
        Phylosofer tmpPH;
        Fork tmpF;
        for (int i = 0; i < forks.amountOfForks; i++) {
            tmpF = forks.leftAndGet();
            tmpPH = new Phylosofer(3000, 3000, 14,false);
            tmpPH.leftFork = tmpF.leftFork;
            tmpPH.rightFork = tmpF;
            tmpPH.myNumber = tmpF.myNumber;
            phylosofers.add(tmpPH);
        }
    }

    void startBanquet() {
        for (Phylosofer ph:phylosofers
             ) {
            ph.start();
        }
    }
}
