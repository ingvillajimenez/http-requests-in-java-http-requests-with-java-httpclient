package com.loonycorn;

import java.net.URI; // final class URI
import java.net.http.HttpClient; // abstract class HttpClient
import java.net.http.HttpRequest; // abstract class HttpRequest
import java.net.http.HttpResponse; // interface HttpResponse
import java.util.*;
import java.util.Map.Entry; // static interface Map.Entry

import org.json.JSONObject; // class JSONObject

import java.util.concurrent.CompletableFuture; // class CompletableFuture

//import java.util.Date; // class Date
//import java.nio.file.Path; // interface Path
//import java.nio.file.Paths; // class Paths

public class MyHttpClient {

    public static void main(String[] args) throws Exception {

        List<String> list = new ArrayList<>();

        list.add("https://reqres.in/api/users/5");
        list.add("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        list.add("https://swapi.dev/api/planets/3/");

        Map<String, CompletableFuture<HttpResponse<String>>> responses = new HashMap<>();

        HttpClient client = HttpClient.newHttpClient();

        for (String url : list) {

            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            CompletableFuture<HttpResponse<String>> future = null;
            future = client.sendAsync(req, HttpResponse.BodyHandlers.ofString());

            responses.put(url, future);
        }

        System.out.println("Requests sent out. Ready to do some more work...");
        //Requests sent out. Ready to do some more work...
        Thread.sleep(5000);
        System.out.println("Ready to process responses...\n ");
        //Ready to process responses...

        for (Entry<String, CompletableFuture<HttpResponse<String>>> entry:
                responses.entrySet()) {

            String responseBody = entry.getValue().thenApply(HttpResponse::body).get();

            System.out.println("\n######## URL: " + entry.getKey());
            //######## URL: https://swapi.dev/api/planets/3/
            //######## URL: https://reqres.in/api/users/5
            //######## URL: https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
            System.out.println("\nThe response body:");
            //The response body:
            //The response body:
            //The response body:
            JSONObject jsonObject = new JSONObject(responseBody);
            System.out.println(jsonObject.toString(4));
            //{
            //    "films": ["https://swapi.dev/api/films/1/"],
            //    "edited": "2014-12-20T20:58:18.421000Z",
            //    "created": "2014-12-10T11:37:19.144000Z",
            //    "climate": "temperate, tropical",
            //    "rotation_period": "24",
            //    "url": "https://swapi.dev/api/planets/3/",
            //    "population": "1000",
            //    "orbital_period": "4818",
            //    "surface_water": "8",
            //    "diameter": "10200",
            //    "gravity": "1 standard",
            //    "name": "Yavin IV",
            //    "residents": [],
            //    "terrain": "jungle, rainforests"
            //}
            //{
            //    "data": {
            //        "last_name": "Morris",
            //        "id": 5,
            //        "avatar": "https://reqres.in/img/faces/5-image.jpg",
            //        "first_name": "Charles",
            //        "email": "charles.morris@reqres.in"
            //    },
            //    "support": {
            //        "text": "To keep ReqRes free, contributions towards server costs are appreciated!",
            //        "url": "https://reqres.in/#support-heading"
            //    }
            //}
            //{
            //    "date": "2023-08-16",
            //    "copyright": "Mike Selby",
            //    "media_type": "image",
            //    "hdurl": "https://apod.nasa.gov/apod/image/2308/NGC-7284-7285-LRGB-crop-CDK-1000-7-August-2023.jpg",
            //    "service_version": "v1",
            //    "explanation": "Locked in a cosmic embrace, two large galaxies are merging at the center of this sharp telescopic field of view. The interacting system cataloged as Arp 93 is some 200 million light-years distant toward the constellation Aquarius in planet Earth's sky. Individually the galaxies are identified as NGC 7285 (right) and NGC 7284. Their bright cores are still separated by about 20,000 light-years or so, but a massive tidal stream, a result of their ongoing gravitational interaction, extends over 200,000 light-years toward the bottom of the frame. Interacting galaxies do look peculiar, but are now understood to be common in the Universe. In fact, closer to home, the large spiral Andromeda Galaxy is known to be approaching the Milky Way. Arp 93 may well present an analog of their distant future cosmic embrace.   Notable submissions to APOD: Perseids Meteor Shower 2023",
            //    "title": "Arp 93: A Cosmic Embrace",
            //    "url": "https://apod.nasa.gov/apod/image/2308/NGC-7284-7285-LRGB-crop-CDK-1000-7-August-2023x1024.jpg"
            //}
        }

//        String url = "https://reqres.in/api/users?delay=10";
//
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpRequest req = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .build();
//
//        System.out.println("Creating the future. Time: " + (new Date()).toString());
//        //Creating the future. Time: Wed Aug 16 15:24:28 CDT 2023
//
//        CompletableFuture<HttpResponse<Path>> future = null;
//        future = client.sendAsync(req, HttpResponse.BodyHandlers
//                .ofFile(Paths.get("response_async.txt")));
//
//        System.out.println("Future created. Time: " + (new Date()).toString());
//        //Future created. Time: Wed Aug 16 15:24:28 CDT 2023
//
//        try {
//            System.out.println("Sleeping for a few seconds now...");
//            //Sleeping for a few seconds now...
//            Thread.sleep(8000);
//            System.out.println("Waking up...Let's see where the response is!");
//            //Waking up...Let's see where the response is!
//        }
//        catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
//
//        Path resp = future.thenApply(HttpResponse::body).get();
//
//        System.out.println("Parsing the response. Time: " + (new Date()).toString());
//        //Parsing the response. Time: Wed Aug 16 15:24:39 CDT 2023
//
//        JSONObject jsonObj = new JSONObject(resp);
//        System.out.println("JSON:\n" + jsonObj.toString(4));
//        //JSON:
//        //{}

    }
}

// JSON processor
// https://mvnrepository.com/artifact/org.json/json

// java.time.Duration
// https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/time/Duration.html