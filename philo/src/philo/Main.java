package com.philo;

import com.philo.model.Fork;
import com.philo.model.PhiloConfig;
import com.philo.model.Philosopher;
import com.philo.utils.Utils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		int philoNumber = Integer.parseInt(args[0]);
		int timeToDie = Integer.parseInt(args[1]);
		int timeToEat = Integer.parseInt(args[2]);
		int timeToSleep = Integer.parseInt(args[3]);
		long startTime = System.nanoTime();
		PhiloConfig philoConfig = new PhiloConfig(timeToDie, timeToEat, timeToSleep, startTime);

		List<Fork> forks = new ArrayList<>();
		List<Philosopher> philos = new ArrayList<>();


		for (int i = 0; i <= philoNumber; i++) {
			if (i < 5)
				forks.add(new Fork(i + 1));
			if (i > 0 && i < 5)
				philos.add(new Philosopher(i, forks.get(i - 1), forks.get(i), philoConfig));
			else if (i == 5)
				philos.add(new Philosopher(i, forks.get(i - 1), forks.get(0), philoConfig));
		}

		for (int i = 0; i < philoNumber; i++) {
			if (philoNumber == i + 1)
				Utils.Delay(timeToEat / 2);
			philos.get(i).start();
		}

		for (int i = 0; i < philoNumber; i++) {
			philos.get(i).join();
		}
	}
}
