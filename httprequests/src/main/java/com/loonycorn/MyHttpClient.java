package com.loonycorn;

import org.json.JSONObject; // class JSONObject

import java.net.URI; // final class URI
import java.net.http.HttpClient; // abstract class HttpClient
import java.net.http.HttpRequest; // abstract class HttpRequest
import java.net.http.HttpResponse; // interface HttpResponse
import java.nio.file.Path; // interface Path
import java.nio.file.Paths; // final class Paths

public class MyHttpClient {

    public static void main(String[] args) throws Exception {

        String url = "https://reqres.in/api/users?page=2";
//        String url = "https://reqres.in/api/users";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

//        HttpResponse<Path> resp = client.send(req, HttpResponse.BodyHandlers
//                .ofFile(Paths.get("response.txt")));
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + resp.statusCode());
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

//        System.out.println("URI: " + resp.uri());
//        //URI: https://reqres.in/api/users
//
//        System.out.println("\nHeaders:\n" + resp.headers());
//        //Headers:
//        //java.net.http.HttpHeaders@d2519d37 { {:status=[200], accept-ranges=[bytes], access-control-allow-origin=[*], age=[4721], cache-control=[max-age=14400], cf-cache-status=[HIT], cf-ray=[7f75c825da7ce7b7-DFW], content-length=[996], content-type=[application/json; charset=utf-8], date=[Wed, 16 Aug 2023 01:07:41 GMT], etag=[W/"3e4-2RLXvr5wTg9YQ6aH95CkYoFNuO8"], nel=[{"success_fraction":0,"report_to":"cf-nel","max_age":604800}], report-to=[{"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=ciq3li4BE4TSr4XTl09AHCuPl4c1MOMU0FG6DwcX2thsdDL2cGnyyTpGSOvzxCEQ071nm1QGG29D0Wat4BPC3BFM59w8k15kTUVmaH1asxDqKVFfzVSJwyeP6Q%3D%3D"}],"group":"cf-nel","max_age":604800}], server=[cloudflare], via=[1.1 vegur], x-powered-by=[Express]} }
//        System.out.println("Content type (first): "
//                + resp.headers().firstValue("content-type"));
//        //Content type (first): Optional[application/json; charset=utf-8]
//        System.out.println("Content type (all): "
//                + resp.headers().allValues("content-type"));
//        //Content type (all): [application/json; charset=utf-8]
//
//        System.out.println("Body:\n" + resp.body());
//        //Body:
//        //response.txt
//        //{"page":1,"per_page":6,"total":12,"total_pages":2,"data":[{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://reqres.in/img/faces/1-image.jpg"},{"id":2,"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://reqres.in/img/faces/2-image.jpg"},{"id":3,"email":"emma.wong@reqres.in","first_name":"Emma","last_name":"Wong","avatar":"https://reqres.in/img/faces/3-image.jpg"},{"id":4,"email":"eve.holt@reqres.in","first_name":"Eve","last_name":"Holt","avatar":"https://reqres.in/img/faces/4-image.jpg"},{"id":5,"email":"charles.morris@reqres.in","first_name":"Charles","last_name":"Morris","avatar":"https://reqres.in/img/faces/5-image.jpg"},{"id":6,"email":"tracey.ramos@reqres.in","first_name":"Tracey","last_name":"Ramos","avatar":"https://reqres.in/img/faces/6-image.jpg"}],"support":{"url":"https://reqres.in/#support-heading","text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}
    }
}

// JSON processor
// https://mvnrepository.com/artifact/org.json/json