package com.philo.utils;

import java.time.Duration;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    public static void Delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, "An error interrupted the thread", e);
        }
    }

    public static void Print (long startTime, int philoId, String message) {
        long currentTime = (System.nanoTime() - startTime) / 1_000_000;
        System.out.printf(
                "%d %d %s\n",
                currentTime,
                philoId,
                message
        );
    }
}
