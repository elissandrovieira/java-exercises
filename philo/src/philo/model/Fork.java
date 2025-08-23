package com.philo.model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final int id;
    private AtomicBoolean isAvailable = new AtomicBoolean();
    private final ReentrantLock lock = new ReentrantLock();
    private Thread owner;

    public Fork(int id) {
        this.id = id;
        isAvailable.set(true);
    }
    public void Grab() {
        lock.lock();
        isAvailable.set(false);
        owner = Thread.currentThread();
    }
    public void Leave() {
        if(owner == Thread.currentThread()) {
            lock.unlock();
            isAvailable.set(true);
        }
    }

    public boolean getAvailability() {return isAvailable.get();}
//        LocalTime now = LocalTime.now();
//        System.out.printf( "%d %d has taken a fork %d\n", Duration.between(start, now).toMillis(), philoId, id);
}
