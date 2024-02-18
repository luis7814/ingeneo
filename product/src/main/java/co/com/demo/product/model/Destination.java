package co.com.demo.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "DESTINATIONS")
public class Destination {

    @Id
    @Column (name = "destination_id")
    private String destinationId;

    @Column (name = "type")
    private String type;

    @Column (name = "name")
    private String name;

    @Column (name = "location")
    private String location;

    @Column (name = "ability")
    private String ability;


}
