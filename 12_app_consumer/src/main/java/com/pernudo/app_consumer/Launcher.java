package com.pernudo.app_consumer;

import com.pernudo.app_consumer.components.Consumer;

public class Launcher{

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.suscribe("topic_test");
    }
}