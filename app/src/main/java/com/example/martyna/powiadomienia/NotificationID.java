package com.example.martyna.powiadomienia;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Martyna on 2017-12-08.
 */

public class NotificationID {
    private final static AtomicInteger c = new AtomicInteger(0);
    public static int getID() {
        return c.incrementAndGet();
    }
}
