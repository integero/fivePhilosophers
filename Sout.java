package five_philosofers;

public class Sout {
    public static synchronized void prnt(int nTime, String sWhat) {
        for (int i = 0; i < nTime; i++) {
            System.out.print("            ");
        }
        System.out.println(sWhat);
    }
}
