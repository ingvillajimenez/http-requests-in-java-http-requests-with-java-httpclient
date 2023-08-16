package com.loonycorn;

import org.json.JSONObject; // class JSONObject
import java.net.URI; // final class URI
import java.net.http.HttpClient; // abstract class HttpClient
import java.net.http.HttpRequest; // abstract class HttpRequest
import java.net.http.HttpResponse; // interface HttpResponse


public class MyHttpClient {

    public static void main(String[] args) throws Exception {

        String url = "https://reqres.in/api/users/433";
//        String url = "https://reqres.in/api/users/433";
//        String url = "https://reqres.in/api/users;

//        String postData = "{'email':'alice.alison@loonycorn.com'," +
//                "'firstName':'Alice'," +
//                "'lastName':'Alison'}";

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .DELETE()
                .build();

//        HttpRequest req = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .PUT(HttpRequest.BodyPublishers.ofString(postData))
//                .build();

//        HttpRequest req = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .POST(HttpRequest.BodyPublishers.ofString(postData))
//                .build();

        HttpResponse<?> resp = client.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + resp.statusCode());
        //Status: 204
        //Status: 200
        //Status: 201
        System.out.println("Headers:\n" + resp.headers().toString());
        //Headers:
        //java.net.http.HttpHeaders@cd606db9 { {:status=[204], access-control-allow-origin=[*], cf-cache-status=[DYNAMIC], cf-ray=[7f7cff190ce6e766-DFW], content-length=[0], date=[Wed, 16 Aug 2023 22:08:32 GMT], etag=[W/"2-vyGp6PvFo4RvsFtPoIWeCReyIC8"], nel=[{"success_fraction":0,"report_to":"cf-nel","max_age":604800}], report-to=[{"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=NZaTIAApJ6FaaulvslpjAuRLjN6QLKn%2Bfbtlp54487c9XgG4YO7QRZ1RQBXHcGg3w8w2Hz2IWrB6NmCittX1Txi4ctDf8IrbxaE5gCUALct5VCAoZUqO7kOETg%3D%3D"}],"group":"cf-nel","max_age":604800}], server=[cloudflare], via=[1.1 vegur], x-powered-by=[Express]} }
        //Headers:
        //java.net.http.HttpHeaders@c3b23a6c { {:status=[200], access-control-allow-origin=[*], cf-cache-status=[DYNAMIC], cf-ray=[7f7cf400ce0128b7-DFW], content-length=[40], content-type=[application/json; charset=utf-8], date=[Wed, 16 Aug 2023 22:00:57 GMT], etag=[W/"28-aHtkpg5AlVuX689GgsHbuRqTpFg"], nel=[{"success_fraction":0,"report_to":"cf-nel","max_age":604800}], report-to=[{"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=X9Q7lPRBs930Q3VrhGJSO6UZ%2F%2FM8Wno3z1QIBdYj%2BJu30hQJIw5bTpIBqocGsrGuKLp1jy1dpGR7l69tBaGQCCaGxTYI6gAKVqxr%2BdasbYL%2Fdrasn%2FhfWSs9pQ%3D%3D"}],"group":"cf-nel","max_age":604800}], server=[cloudflare], via=[1.1 vegur], x-powered-by=[Express]} }
        //Headers:
        //java.net.http.HttpHeaders@b636be7f { {:status=[201], access-control-allow-origin=[*], cf-cache-status=[DYNAMIC], cf-ray=[7f7ccd918ea12cc8-DFW], content-length=[51], content-type=[application/json; charset=utf-8], date=[Wed, 16 Aug 2023 21:34:43 GMT], etag=[W/"33-uSoBRGxBvjZcqJ1odIp2gtxF644"], nel=[{"success_fraction":0,"report_to":"cf-nel","max_age":604800}], report-to=[{"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=1IuxbVRmCTxcTejLnxb6tkIKRfNIl1UsKANodkUx19zVH8y0rwdrsHKnHM%2B2m8KtugDfW8RRly%2Fgk%2BjJgjJZ1eguJH%2BM%2BhoRDYdiEoeUKaQlxiWSccbMqbCQ%2BA%3D%3D"}],"group":"cf-nel","max_age":604800}], server=[cloudflare], via=[1.1 vegur], x-powered-by=[Express]} }

        System.out.println("Body: " + resp.body().toString());
        //Body:

//        JSONObject jsonObj = new JSONObject(resp.body().toString());
//        System.out.println("JSON:\n" + jsonObj.toString(4));
        //JSON:
        //{"updatedAt": "2023-08-16T22:00:57.921Z"}
        //JSON:
        //{
        //    "createdAt": "2023-08-16T21:34:43.643Z",
        //    "id": "433"
        //}
    }
}

// JSON processor
// https://mvnrepository.com/artifact/org.json/json

// java.time.Duration
// https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/time/Duration.html