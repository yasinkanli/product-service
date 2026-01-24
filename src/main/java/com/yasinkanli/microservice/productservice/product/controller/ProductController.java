package com.yasinkanli.microservice.productservice.product.controller;

import com.yasinkanli.microservice.productservice.product.model.ProductResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
  

  @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getProduct(@PathVariable String productId) {
    return ResponseEntity.ok(new ProductResponse(productId,"Cell Phone"));
  }
}
