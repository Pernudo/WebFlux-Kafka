package com.pernudo.app_consumer;

import com.pernudo.app_consumer.components.Consumer;

public class LauncherConsumer {

    public static void main(String[] args) {
        System.out.println("Inicio de LauncherConsumer");
        Consumer consumer = new Consumer();
        consumer.suscribe("topic_test");
    }
}