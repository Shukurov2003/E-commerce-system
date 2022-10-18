package com.justice.ecommerce.mapper;

import com.justice.ecommerce.dto.ProductDTO;
import com.justice.ecommerce.entity.Product;

public interface ProductDTOFromProductService {
    ProductDTO getProductDTOFromProduct(Product product);
}
