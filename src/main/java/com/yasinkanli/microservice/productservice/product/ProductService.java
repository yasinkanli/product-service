package com.yasinkanli.microservice.productservice.product;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;


  public ProductResponse createProduct(NewProductRequest newProductRequest) {

    var productEntity = new ProductEntity();
    productEntity.setDescription(newProductRequest.description());
    productEntity.setName(newProductRequest.name());
    productEntity.setPrice(newProductRequest.price());
    return toResponse(productRepository.save(productEntity));
  }

  public List<ProductResponse> getAllProducts() {
    var productEntities = productRepository.findAll();
    return productEntities.stream().map(this::toResponse).toList();
  }

  private ProductResponse toResponse(ProductEntity e) {
    return new ProductResponse(
      e.getId(),
      e.getDescription(),
      e.getName(),
      e.getPrice()
    );
  }

  public Optional<ProductResponse> getProductById(Long id) {

    return productRepository.findById(id).map(this::toResponse);
  }

  public boolean deleteProduct(Long id) {
    if (productRepository.existsById(id)) {
      productRepository.deleteById(id);
      return true;
    }
    return false;
  }


  // public Optional<Product> updateProduct(Long id, Product productDetails) { ... }

}