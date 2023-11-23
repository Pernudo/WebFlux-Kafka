package com.pernudo.client_tracker_securized_access.service;

import com.pernudo.client_tracker_securized_access.model.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Base64;

@Service
public class ElementsServiceImpl implements ElementsService{
    @Value("${user}")
    String user;
    @Value("${pass}")
    String password;
    String url1 = "http://localhost:8088";
    String url2 = "http://localhost:9083";
    @Override
    public Flux<Element> elementPriceMax(double priceMax) {
        Flux<Element> flux1 = catalog(url1, "Shop1");
        Flux<Element> flux2 = catalog(url2, "Shop2");
        return Flux.merge(flux1, flux2) //Flux<Element>
                .filter(e -> e.getPrice() <= priceMax);
    }

    private Flux<Element> catalog(String url, String shop){
        WebClient webClient = WebClient.create(url);
        return webClient
                .get()
                .uri("/products")
                .header("Authorization", "Basic " + getEncoderBase64Credentials(user, password))
                .retrieve()
                .bodyToFlux(Element.class)
                .map(e -> {
                    e.setShop(shop);
                    return e;
                });
    }

    private String getEncoderBase64Credentials(String user, String pass){
        String credential = user + ":" + pass;
        return Base64.getEncoder().encodeToString(credential.getBytes());
    }
}
