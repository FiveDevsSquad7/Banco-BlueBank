package com.banco.bluebank.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class ContentIdGenerator {

    static int seq = 0;
    static String hostname;

    public static void getHostname() {
        try {
            hostname = InetAddress.getLocalHost().getCanonicalHostName();
        }
        catch (UnknownHostException e) {
            // we can't find our hostname? okay, use something no one else is
            // likely to use
            hostname = new Random(System.currentTimeMillis()).nextInt(100000) + ".localhost";
        }
    }

    public static synchronized int getSeq() {
        return (seq++) % 100000;
    }

    public static String getContentId() {
        getHostname();
        int c = getSeq();
        return c + "." + System.currentTimeMillis() + "@" + hostname;
    }
}
