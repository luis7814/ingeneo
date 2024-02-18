package co.com.demo.product.repository;

import co.com.demo.product.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, String> {
}
