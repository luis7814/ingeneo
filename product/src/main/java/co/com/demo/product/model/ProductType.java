package co.com.demo.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "PRODUCTS_TYPE")
public class ProductType {

    @Id
    @Column (name = "product_type_id")
    private String productTypeId;

    @Column (name = "description")
    private String description;
}
