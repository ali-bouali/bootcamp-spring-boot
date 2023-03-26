package com.alibou.bootcamp.fakeapistore;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

  private Integer id;
  @JsonProperty("title")
  private String title;
  private BigDecimal price;
  private String description;
  private String category;
  private String image;
  private Rate rating;

}
