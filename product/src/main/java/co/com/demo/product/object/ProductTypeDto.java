package co.com.demo.product.object;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductTypeDto implements Serializable {

    private String productTypeId;
    private String description;
}
