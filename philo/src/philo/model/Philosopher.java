package com.philo.model;

import com.philo.service.PhiloActions;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class Philosopher extends Thread {
	private int id;
	private Fork lfork;
	private Fork rfork;
	private PhiloConfig philoConfig;
	private AtomicBoolean isDied = new AtomicBoolean();
	private long lastMealTime;
	private AtomicBoolean mealIsAvailable = new AtomicBoolean();


	public Philosopher(int id, Fork lfork, Fork rfork, PhiloConfig philoConfig) {
		this.lfork = lfork;
		this.rfork = rfork;
		this.id = id;
		this.philoConfig = philoConfig;
		isDied.set(false);
		mealIsAvailable.set(true);
		lastMealTime = philoConfig.getStartTime();
	}

	public void SetDied() {isDied.set(true);}

	public long getLastMealTime() {
		mealIsAvailable.get();
		return lastMealTime;
	}
	@Override
	public void run() {
		PhiloActions philoActions = new PhiloActions(lfork, rfork, id, philoConfig);

		while(!isDied.get() || !philoConfig.getSimulationEnd()) {
			mealIsAvailable.get();
			philoActions.GrabForks(lastMealTime);
			if (isDied.get() || philoConfig.getSimulationEnd()) {
				philoActions.LeaveForks();
				break;
			}
			philoActions.Action(PhiloActions.Type.EAT);
			mealIsAvailable.set(false);
			lastMealTime = System.nanoTime();
			mealIsAvailable.set(true);
			philoActions.LeaveForks();
			if (isDied.get() || philoConfig.getSimulationEnd())
				break;
			philoActions.Action(PhiloActions.Type.SLEEP);
		}

//		System.out.printf("%d %d is eating\n", Duration.between(time, LocalTime.now()).toMillis(), id);
	}
}
