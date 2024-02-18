package co.com.demo.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table (name = "SHIPPING")
public class Shipping {

    @Id
    @Column (name = "shipping_id")
    private String shippingId;

    @Column (name = "shipping_type")
    private String shippingType;

    @Column (name = "quantity_product")
    private Integer quantityProduct;

    @Column (name = "registration_date")
    private LocalDate registrationDate;

    @Column (name = "deliver_date")
    private LocalDate deliverDate;

    @Column (name = "price_shipping")
    private Double priceShipping;

    @Column (name = "final_price")
    private Double finalPrice;

    @Column (name = "discount_applied")
    private String discountApplied;

    @Column (name = "vehicle_number")
    private String vehicleNumber;

    @Column (name = "guide_number")
    private String guideNumber;

    @Column (name = "product_type_id")
    private String productTypeId;

    @Column (name = "client_id")
    private String clientId;

    @Column (name = "destination_id")
    private String destinationId;


}
