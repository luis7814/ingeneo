package co.com.demo.product.object;

import lombok.Data;

import java.io.Serializable;

@Data
public class DestinationDto implements Serializable {

    private String destinationId;
    private String type;
    private String name;
    private String location;
    private String ability;


}
