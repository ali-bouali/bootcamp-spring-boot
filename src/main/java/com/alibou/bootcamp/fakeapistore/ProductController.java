package com.alibou.bootcamp.fakeapistore;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fake-products")
@RequiredArgsConstructor
@Tag(name = "Fake-Product-API")
public class ProductController {

  private final ProductRepository repository;
  @GetMapping
  public List<Product> findAll() {
    return repository.findAllProductsWithExchange();
  }
}
