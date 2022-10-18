package com.justice.ecommerce.service.Impl;

import com.justice.ecommerce.dto.ProductDTO;
import com.justice.ecommerce.entity.Category;
import com.justice.ecommerce.entity.Product;
import com.justice.ecommerce.exeptions.ProductNotPresentException;
import com.justice.ecommerce.mapper.ProductDTOFromProductService;
import com.justice.ecommerce.model.ApiResponse;
import com.justice.ecommerce.repository.CategoryRepository;
import com.justice.ecommerce.repository.ProductRepository;
import com.justice.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final  ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductDTOFromProductService  fromProductService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductDTOFromProductService fromProductService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.fromProductService = fromProductService;
    }

    @Override
    public ResponseEntity<?> createProduct(ProductDTO productDTO) {

        final Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
        if(!optionalCategory.isPresent()){
            return ResponseEntity.badRequest().body(ApiResponse.error("Category is not found!"));
        }

        Product product = new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getImageURL(),
                productDTO.getPrice(),
                productDTO.getDescription(),
                optionalCategory.get()
        );
        productRepository.save(product);

        return ResponseEntity.ok(ApiResponse.ok(productDTO,"Product has been created!"));
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<Product> allProducts = productRepository.findAll();

        List<ProductDTO> productDTOS =  new ArrayList<>();
        for (Product p : allProducts) {
            productDTOS.add(fromProductService.getProductDTOFromProduct(p));
        }
        return ResponseEntity.ok(ApiResponse.ok(productDTOS,"Here products are!"));
    }

    @Override
    public ResponseEntity<?> updateProduct(ProductDTO productDTO) {

        final Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
        if(!optionalCategory.isPresent()){
            return ResponseEntity.badRequest().body(ApiResponse.error("Category is not found!"));
        }
        Product product = new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getImageURL(),
                productDTO.getPrice(),
                productDTO.getDescription(),
                optionalCategory.get()
        );
        productRepository.save(product);

        return ResponseEntity.ok(ApiResponse.ok(productDTO,"The product has been updated!"));
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            throw new ProductNotPresentException("Product is not present: "+id);
        }
        return product.get();
    }


}
