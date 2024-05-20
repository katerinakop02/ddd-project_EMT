package mk.ukim.finki.emt.ordermanagement.xportClient;

import mk.ukim.finki.emt.ordermanagement.domain.valueObjects.Dish;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class DishClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public DishClient(@Value("${app.product-catalog.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Object> findAll() {
        try {
            return Collections.singletonList(restTemplate.exchange(uri().path("/api/dish").build().toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Dish>>() {
            }).getBody());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
