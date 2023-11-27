package com.pernudo.app_producer;

import com.pernudo.app_producer.components.Producer;

import java.time.LocalDateTime;

public class Launcher{

    public static void main(String[] args) {
        Producer producer = new Producer();
        for (int i=1; i<=10; i++){
            producer.send("topic_test", "Mensaje generado a las " + LocalDateTime.now() + "para topic_test");
        }
        producer.close();
    }
}