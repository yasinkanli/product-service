package com.yasinkanli.microservice.productservice.product;

import java.math.BigDecimal;

public record ProductResponse(long productId,String name,String description,BigDecimal price) {

}
