package com.justice.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justice.ecommerce.dto.ProductDTO;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotBlank String name;
    private @NotBlank String imageURL;
    private @NotBlank BigDecimal price;
    private @NotBlank String description;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JoinColumn(name = "category_id")
    Category category;


    public Product( Long productId,String name, String imageURL, BigDecimal price, String description,Category category){
        this.id = productId;
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
        this.description = description;
        this.category = category;

    }


    public Product() {

    }

    public Product(ProductDTO productDTO) {

        this.setId(productDTO.getId());
        this.setName(productDTO.getName());
        this.setImageURL(productDTO.getImageURL());
        this.setPrice(productDTO.getPrice());
        this.setDescription(productDTO.getDescription());
        this.getCategory().setId(productDTO.getCategoryId());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
