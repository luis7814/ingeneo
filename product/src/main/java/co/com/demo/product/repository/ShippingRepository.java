package co.com.demo.product.repository;

import co.com.demo.product.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, String> {
}
