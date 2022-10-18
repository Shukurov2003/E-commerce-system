package com.justice.ecommerce.mapper.implMapper;

import com.justice.ecommerce.dto.ProductDTO;
import com.justice.ecommerce.entity.Product;
import com.justice.ecommerce.mapper.ProductDTOFromProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductDTOFromProduct implements ProductDTOFromProductService {
    @Override
    public ProductDTO getProductDTOFromProduct(Product product){
        ProductDTO productDTO = new ProductDTO(product);
        return productDTO;

    }
}
