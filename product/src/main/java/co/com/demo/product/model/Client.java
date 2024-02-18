package co.com.demo.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "CLIENTS")
public class Client {

    @Id
    @Column (name = "client_id")
    private String clientId;

    @Column (name = "name")
    private String name;

    @Column (name = "mobile_phone")
    private String mobilePhone;

    @Column (name = "email")
    private String email;




}
