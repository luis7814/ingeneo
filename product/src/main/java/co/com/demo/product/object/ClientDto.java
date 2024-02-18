package co.com.demo.product.object;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientDto implements Serializable {

    private String clientId;
    private String name;
    private String mobilePhone;
    private String email;




}
