package com.yasinkanli.microservice.productservice.product;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController{

  private final ProductService productService;

  @GetMapping(value = "/{productId}", produces= MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductResponse> getProduct(@PathVariable Long productId) throws Exception{
    Optional<ProductResponse> product = productService.getProductById(productId);
    return product.map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductResponse createProduct(@RequestBody NewProductRequest product) {
    return productService.createProduct(product);
  }

  @GetMapping
  public List<ProductResponse> getAllProducts() {
    return productService.getAllProducts();
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
    boolean isDeleted = productService.deleteProduct(productId);
    if (isDeleted) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
