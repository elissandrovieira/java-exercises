package com.philo.model;

import com.philo.utils.Utils;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Monitor extends Thread{
    List<Philosopher> philos;
    PhiloConfig philoConfig;
    int philoNumber;

    public Monitor(List<Philosopher> philos, PhiloConfig philoConfig, int philoNumber) {
        this.philos = philos;
        this.philoConfig = philoConfig;
        this.philoNumber = philoNumber;
    }

    @Override
    public void run(){
        int i = 0;

        while (true) {
            long LastMealTime = (System.nanoTime() - philos.get(i).getLastMealTime()) / 1_000_000;
            if( LastMealTime > philoConfig.getTimeToDie()) {
                philos.get(i).SetDied();
                philoConfig.setSimulationEnd();
                break;
            }
            i++;
            if (i == philoNumber)
                i = 0;
            Utils.Delay(300);
        }
    }
}
