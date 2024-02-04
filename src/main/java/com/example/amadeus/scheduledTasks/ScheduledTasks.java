package com.example.amadeus.scheduledTasks;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ScheduledTasks {
    @Scheduled(cron = "0 0 1 * * ?")//at 01:00 everyday
    public void findNewFlights() throws IOException, InterruptedException {
        /***
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://lihcode-lufthansa-open-new-v1.p.rapidapi.com/v1/cargo/getRoute/%7Borigin%7D-%7Bdestination%7D/%7Bfromdate%7D/%7Bproductcode%7D"))
                .header("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
                .header("X-RapidAPI-Host", "lihcode-lufthansa-open-new-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
         ***/
    }
}
