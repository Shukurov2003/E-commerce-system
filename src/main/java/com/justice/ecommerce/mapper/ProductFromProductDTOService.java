package com.justice.ecommerce.mapper;

import com.justice.ecommerce.dto.ProductDTO;
import com.justice.ecommerce.entity.Product;

public interface ProductFromProductDTOService {
    Product getProductFromProductDTO(ProductDTO productDTO);
}
