package co.com.demo.product.object;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ShippingDto implements Serializable {

    private String shippingId;
    private String shippingType;
    private Integer quantityProduct;
    private LocalDate registrationDate;
    private LocalDate deliverDate;
    private Double priceShipping;
    private Double finalPrice;
    private String discountApplied;
    private String vehicleNumber;
    private String guideNumber;
    private String productTypeId;
    private String clientId;
    private String destinationId;


}
