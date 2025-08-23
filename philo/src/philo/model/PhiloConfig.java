package com.philo.model;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhiloConfig {
    private int timeToDie;
    private int timeToEat;
    private int timeToSleep;
    private long startTime;
    private AtomicBoolean simulationEnd = new AtomicBoolean();

    public PhiloConfig(int timeToDie, int timeToEat, int timeToSleep, long startTime) {
        this.timeToDie = timeToDie;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
        this.startTime = startTime;
        simulationEnd.set(false);
    }

    public int getTimeToDie() {
        return timeToDie;
    }

    public int getTimeToEat() {
        return timeToEat;
    }

    public int getTimeToSleep() {
        return timeToSleep;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setSimulationEnd() {
        simulationEnd.set(true);
    }

    public boolean getSimulationEnd() {
        return simulationEnd.get();
    }
}
