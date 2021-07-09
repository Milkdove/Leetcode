package leetcode;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread extends Thread {

    @Override
    public void run() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        System.out.println(format.format(now));
    }

    public static void main(String[] args) {
        TimeThread timeThread = new TimeThread();
        timeThread.start();
    }

}
