package com.five_philosophers;

public class Sout {
    public static void prnt(int nTime, String sWhat) {
        String[] sout = {"%20s\n", "%40s\n", "%60s\n", "%80s\n","%100s\n"};
        System.out.printf(sout[nTime],sWhat);
    }
}
