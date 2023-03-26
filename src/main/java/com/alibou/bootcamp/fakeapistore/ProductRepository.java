package com.alibou.bootcamp.fakeapistore;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

  private final RestTemplate restTemplate;
  @Value("${fake-api.store.url}")
  private String apiUrl;

  public List<Product> findAllProducts() {
    var products = restTemplate.getForObject(apiUrl, Product[].class);
    return Arrays.asList(products);
  }
  public List<Product> findAllProductsWithExchange() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");

    HttpEntity<String> entity = new HttpEntity<>(headers);
    ResponseEntity<Product[]> products = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Product[].class);
    return Arrays.asList(products.getBody());
  }


}
