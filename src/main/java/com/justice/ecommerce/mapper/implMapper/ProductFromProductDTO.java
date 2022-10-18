package com.justice.ecommerce.mapper.implMapper;

import com.justice.ecommerce.dto.ProductDTO;
import com.justice.ecommerce.entity.Product;
import com.justice.ecommerce.mapper.ProductFromProductDTOService;
import org.springframework.stereotype.Service;

@Service
public class ProductFromProductDTO implements ProductFromProductDTOService {

    @Override
    public Product getProductFromProductDTO(ProductDTO productDTO){
        Product product = new Product(productDTO);
        return product;
    }
}
