package com.loonycorn;

import java.net.URI; // final class URI
import java.net.http.HttpClient; // abstract class HttpClient
import java.net.http.HttpRequest; // abstract class HttpRequest
import java.net.http.HttpResponse; // interface HttpResponse
import org.json.JSONObject; // class JSONObject
import java.util.concurrent.CompletableFuture; // class CompletableFuture
import java.util.Date; // class Date

public class MyHttpClient {

    public static void main(String[] args) throws Exception {

        String url = "https://reqres.in/api/users?delay=10";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        System.out.println("Creating the future. Time: " + (new Date()).toString());
        //Creating the future. Time: Wed Aug 16 14:48:59 CDT 2023
        //Creating the future. Time: Wed Aug 16 14:42:33 CDT 2023

        CompletableFuture<HttpResponse<String>> future = null;
        future = client.sendAsync(req, HttpResponse.BodyHandlers.ofString());

        System.out.println("Future created. Time: " + (new Date()).toString());
        //Future created. Time: Wed Aug 16 14:49:00 CDT 2023
        //Future created. Time: Wed Aug 16 14:42:33 CDT 2023

        try {
            System.out.println("Sleeping for a few seconds now...");
            //Sleeping for a few seconds now...
            Thread.sleep(8000);
            System.out.println("Waking up...Let's see where the response is!");
            //Waking up...Let's see where the response is!
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        String resp = future.thenApply(HttpResponse::body).get();

        System.out.println("Parsing the response. Time: " + (new Date()).toString());
        //Parsing the response. Time: Wed Aug 16 14:49:10 CDT 2023
        //Parsing the response. Time: Wed Aug 16 14:42:44 CDT 2023

        JSONObject jsonObj = new JSONObject(resp);
        System.out.println("JSON:\n" + jsonObj.toString(4));
        //JSON:
        //{
        //    "per_page": 6,
        //    "total": 12,
        //    "data": [
        //        {
        //            "last_name": "Bluth",
        //            "id": 1,
        //            "avatar": "https://reqres.in/img/faces/1-image.jpg",
        //            "first_name": "George",
        //            "email": "george.bluth@reqres.in"
        //        },
        //        {
        //            "last_name": "Weaver",
        //            "id": 2,
        //            "avatar": "https://reqres.in/img/faces/2-image.jpg",
        //            "first_name": "Janet",
        //            "email": "janet.weaver@reqres.in"
        //        },
        //        {
        //            "last_name": "Wong",
        //            "id": 3,
        //            "avatar": "https://reqres.in/img/faces/3-image.jpg",
        //            "first_name": "Emma",
        //            "email": "emma.wong@reqres.in"
        //        },
        //        {
        //            "last_name": "Holt",
        //            "id": 4,
        //            "avatar": "https://reqres.in/img/faces/4-image.jpg",
        //            "first_name": "Eve",
        //            "email": "eve.holt@reqres.in"
        //        },
        //        {
        //            "last_name": "Morris",
        //            "id": 5,
        //            "avatar": "https://reqres.in/img/faces/5-image.jpg",
        //            "first_name": "Charles",
        //            "email": "charles.morris@reqres.in"
        //        },
        //        {
        //            "last_name": "Ramos",
        //            "id": 6,
        //            "avatar": "https://reqres.in/img/faces/6-image.jpg",
        //            "first_name": "Tracey",
        //            "email": "tracey.ramos@reqres.in"
        //        }
        //    ],
        //    "page": 1,
        //    "total_pages": 2,
        //    "support": {
        //        "text": "To keep ReqRes free, contributions towards server costs are appreciated!",
        //        "url": "https://reqres.in/#support-heading"
        //    }
        //}
        //JSON:
        //{
        //    "per_page": 6,
        //    "total": 12,
        //    "data": [
        //        {
        //            "last_name": "Bluth",
        //            "id": 1,
        //            "avatar": "https://reqres.in/img/faces/1-image.jpg",
        //            "first_name": "George",
        //            "email": "george.bluth@reqres.in"
        //        },
        //        {
        //            "last_name": "Weaver",
        //            "id": 2,
        //            "avatar": "https://reqres.in/img/faces/2-image.jpg",
        //            "first_name": "Janet",
        //            "email": "janet.weaver@reqres.in"
        //        },
        //        {
        //            "last_name": "Wong",
        //            "id": 3,
        //            "avatar": "https://reqres.in/img/faces/3-image.jpg",
        //            "first_name": "Emma",
        //            "email": "emma.wong@reqres.in"
        //        },
        //        {
        //            "last_name": "Holt",
        //            "id": 4,
        //            "avatar": "https://reqres.in/img/faces/4-image.jpg",
        //            "first_name": "Eve",
        //            "email": "eve.holt@reqres.in"
        //        },
        //        {
        //            "last_name": "Morris",
        //            "id": 5,
        //            "avatar": "https://reqres.in/img/faces/5-image.jpg",
        //            "first_name": "Charles",
        //            "email": "charles.morris@reqres.in"
        //        },
        //        {
        //            "last_name": "Ramos",
        //            "id": 6,
        //            "avatar": "https://reqres.in/img/faces/6-image.jpg",
        //            "first_name": "Tracey",
        //            "email": "tracey.ramos@reqres.in"
        //        }
        //    ],
        //    "page": 1,
        //    "total_pages": 2,
        //    "support": {
        //        "text": "To keep ReqRes free, contributions towards server costs are appreciated!",
        //        "url": "https://reqres.in/#support-heading"
        //    }
        //}
        //JSON:
        //{
        //    "per_page": 6,
        //    "total": 12,
        //    "data": [
        //        {
        //            "last_name": "Bluth",
        //            "id": 1,
        //            "avatar": "https://reqres.in/img/faces/1-image.jpg",
        //            "first_name": "George",
        //            "email": "george.bluth@reqres.in"
        //        },
        //        {
        //            "last_name": "Weaver",
        //            "id": 2,
        //            "avatar": "https://reqres.in/img/faces/2-image.jpg",
        //            "first_name": "Janet",
        //            "email": "janet.weaver@reqres.in"
        //        },
        //        {
        //            "last_name": "Wong",
        //            "id": 3,
        //            "avatar": "https://reqres.in/img/faces/3-image.jpg",
        //            "first_name": "Emma",
        //            "email": "emma.wong@reqres.in"
        //        },
        //        {
        //            "last_name": "Holt",
        //            "id": 4,
        //            "avatar": "https://reqres.in/img/faces/4-image.jpg",
        //            "first_name": "Eve",
        //            "email": "eve.holt@reqres.in"
        //        },
        //        {
        //            "last_name": "Morris",
        //            "id": 5,
        //            "avatar": "https://reqres.in/img/faces/5-image.jpg",
        //            "first_name": "Charles",
        //            "email": "charles.morris@reqres.in"
        //        },
        //        {
        //            "last_name": "Ramos",
        //            "id": 6,
        //            "avatar": "https://reqres.in/img/faces/6-image.jpg",
        //            "first_name": "Tracey",
        //            "email": "tracey.ramos@reqres.in"
        //        }
        //    ],
        //    "page": 1,
        //    "total_pages": 2,
        //    "support": {
        //        "text": "To keep ReqRes free, contributions towards server costs are appreciated!",
        //        "url": "https://reqres.in/#support-heading"
        //    }
        //}

    }
}

// JSON processor
// https://mvnrepository.com/artifact/org.json/json

// java.time.Duration
// https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/time/Duration.html