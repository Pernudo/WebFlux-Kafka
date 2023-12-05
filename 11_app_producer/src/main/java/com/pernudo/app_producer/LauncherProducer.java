package com.pernudo.app_producer;

import com.pernudo.app_producer.components.Producer;

import java.time.LocalDateTime;

public class LauncherProducer {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicio de LauncherProducer");
        Producer producer = new Producer();
        for (int i=1; i<=10; i++){
            System.out.println("Dentro del bucle del productor "+ i +"!!!");
            producer.send("topic_test", "Mensaje generado a las " + LocalDateTime.now() + "para topic_test");
            Thread.sleep(500);
        }
        producer.close();
    }
}