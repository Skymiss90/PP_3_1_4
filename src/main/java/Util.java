package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Util {
    private static final String url = "http://94.198.50.185:7081/api/users";
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public Util() {
        restTemplate = new RestTemplate();
        String headerString = restTemplate.headForHeaders(url, String.class).get("Set-cookie").get(0);
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Cookie", headerString);
        System.out.println(httpHeaders);
    }

    public List getAll() {
        HttpEntity<String> entity = new HttpEntity<>("", httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET, entity, List.class).getBody();
    }

    public String save(User user) {
        HttpEntity<User> entity = new HttpEntity<>(user, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
    }

    public String patch(User user) {
        HttpEntity<User> entity = new HttpEntity<>(user, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class).getBody();
    }

    public String delete(Long id) {
        HttpEntity<String> entity = new HttpEntity<>("", httpHeaders);
        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }


}
