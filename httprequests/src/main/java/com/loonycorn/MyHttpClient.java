package com.loonycorn;

import org.json.JSONObject; // class JSONObject

import java.net.URI; // final class URI
import java.net.http.HttpClient; // abstract class HttpClient
import java.net.http.HttpRequest; // abstract class HttpRequest
import java.net.http.HttpResponse; // interface HttpResponse
import java.time.Duration; // final class Duration

public class MyHttpClient {

    public static void main(String[] args) throws Exception {

        String url = "https://reqres.in/api/users?delay=10";
//        String url = "https://reqres.in/api/users?page=2&delay=5";
//        String url = "https://reqres.in/api/users?page=2";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .timeout(Duration.ofMillis(15000))
//                .timeout(Duration.ofMillis(5000))
                .build();

//        HttpRequest req = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .GET()
//                .timeout(Duration.ofSeconds(5))
//                .build();

//        HttpRequest req = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .GET()
//                .build();

//        HttpRequest req = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .build();

        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        //Exception in thread "main" java.net.http.HttpTimeoutException: request timed out
        //	at java.net.http/jdk.internal.net.http.HttpClientImpl.send(HttpClientImpl.java:561)
        //	at java.net.http/jdk.internal.net.http.HttpClientFacade.send(HttpClientFacade.java:119)
        //	at com.loonycorn.MyHttpClient.main(MyHttpClient.java:36)

        System.out.println("Status code: " + resp.statusCode());
        //Status code: 200
        //Status code: 200
        System.out.println("Body: ");
        JSONObject jsonObj = new JSONObject(resp.body().toString());
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
        //            "last_name": "Lawson",
        //            "id": 7,
        //            "avatar": "https://reqres.in/img/faces/7-image.jpg",
        //            "first_name": "Michael",
        //            "email": "michael.lawson@reqres.in"
        //        },
        //        {
        //            "last_name": "Ferguson",
        //            "id": 8,
        //            "avatar": "https://reqres.in/img/faces/8-image.jpg",
        //            "first_name": "Lindsay",
        //            "email": "lindsay.ferguson@reqres.in"
        //        },
        //        {
        //            "last_name": "Funke",
        //            "id": 9,
        //            "avatar": "https://reqres.in/img/faces/9-image.jpg",
        //            "first_name": "Tobias",
        //            "email": "tobias.funke@reqres.in"
        //        },
        //        {
        //            "last_name": "Fields",
        //            "id": 10,
        //            "avatar": "https://reqres.in/img/faces/10-image.jpg",
        //            "first_name": "Byron",
        //            "email": "byron.fields@reqres.in"
        //        },
        //        {
        //            "last_name": "Edwards",
        //            "id": 11,
        //            "avatar": "https://reqres.in/img/faces/11-image.jpg",
        //            "first_name": "George",
        //            "email": "george.edwards@reqres.in"
        //        },
        //        {
        //            "last_name": "Howell",
        //            "id": 12,
        //            "avatar": "https://reqres.in/img/faces/12-image.jpg",
        //            "first_name": "Rachel",
        //            "email": "rachel.howell@reqres.in"
        //        }
        //    ],
        //    "page": 2,
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