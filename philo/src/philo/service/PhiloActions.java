package com.philo.service;

import com.philo.model.Fork;
import com.philo.model.PhiloConfig;
import com.philo.utils.Utils;

import java.time.Duration;
import java.time.LocalTime;

public class PhiloActions {
    private Fork lfork;
    private Fork rfork;
    private int philoId;
    private PhiloConfig philoConfig;

    public enum Type {
        EAT,
        SLEEP,
    }
    public enum ForkSide {
        LEFT,
        RIGHT
    }

    public PhiloActions(Fork lfork, Fork rfork, int philoId, PhiloConfig philoConfig) {
        this.lfork = lfork;
        this.rfork = rfork;
        this.philoId = philoId;
        this.philoConfig = philoConfig;
    }

    private boolean GrabFork(ForkSide side, long currentTime) {
        String message = "";
        Fork fork;

        switch (side) {
            case LEFT:
                message = "has taken the left fork";
                fork = lfork;
                break;

            case RIGHT:
                message = "has taken the right fork";
                fork = rfork;
                break;

            default:
                throw new IllegalArgumentException("Unknown side: " + side);
        }

        int i = 0;
        while (
                !fork.getAvailability()
                && philoConfig.getTimeToDie() > (System.nanoTime() - currentTime) / 1_000_000
        ) {
            if (i == 0 && side == ForkSide.LEFT)
                Utils.Print(philoConfig.getStartTime(), philoId, "is thinking");
            i++;
        }
        long timeNow = (System.nanoTime() - currentTime) / 1_000_000;
        if (philoConfig.getTimeToDie() > timeNow) {
                fork.Grab();
                Utils.Print(philoConfig.getStartTime(), philoId, message);
                return true;
        }
        return false;
    }

    public void GrabForks(long nowTime) {
        if (GrabFork(ForkSide.LEFT, nowTime))
            GrabFork(ForkSide.RIGHT, nowTime);
    }

    public void LeaveForks() {
        if (!lfork.getAvailability())
            lfork.Leave();
        if (!rfork.getAvailability())
            rfork.Leave();
    }

    public void Action (Type actionType) {
        String message = "";
        int delayTime = 0;

        switch (actionType) {
            case EAT:
                message = "is eating";
                delayTime = philoConfig.getTimeToEat();
                break;

            case SLEEP:
                message = "is sleeping";
                delayTime = philoConfig.getTimeToSleep();
                break;
        }

        Utils.Print(philoConfig.getStartTime(), philoId, message);
        Utils.Delay(delayTime);
    }
}
