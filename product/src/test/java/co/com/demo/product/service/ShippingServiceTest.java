package co.com.demo.product.service;

import co.com.demo.product.model.Shipping;
import co.com.demo.product.object.ShippingDto;
import co.com.demo.product.object.ShippingDto;
import co.com.demo.product.repository.ShippingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class ShippingServiceTest {
    @Mock
    ShippingRepository shippingRepository;
    
    @InjectMocks
    ShippingService shippingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testUpdate() {
        ShippingDto result = shippingService.update(shippingDtoData());
        Assertions.assertEquals("1", result.getShippingId());
    }

    @Test
    void testFindById() {
        when(shippingRepository.findById("id")).thenReturn((Optional.of(shippingData())));
        ShippingDto result = shippingService.findById("id");
        Assertions.assertEquals(shippingDtoData().getShippingId(), result.getShippingId());
    }

    @Test
    void testFindAll() {
        List<ShippingDto> result = shippingService.findAll();
        Assertions.assertNotNull(result);
    }

    private ShippingDto shippingDtoData() {

        ShippingDto shippingDto = new ShippingDto();
        shippingDto.setShippingId("1");
        shippingDto.setPriceShipping(0.0);
        shippingDto.setClientId("1");
        shippingDto.setDeliverDate(LocalDate.now());
        shippingDto.setShippingType("Type");
        shippingDto.setDestinationId("1");
        shippingDto.setDiscountApplied("12");
        shippingDto.setFinalPrice(0.0);
        shippingDto.setGuideNumber("123123123123");
        shippingDto.setQuantityProduct(10000);
        shippingDto.setRegistrationDate(LocalDate.now());
        shippingDto.setVehicleNumber("123435");

        return shippingDto;
    }

    private Shipping shippingData() {

        Shipping shipping = new Shipping();
        shipping.setShippingId("1");
        shipping.setPriceShipping(0.0);
        shipping.setClientId("1");
        shipping.setDeliverDate(LocalDate.now());
        shipping.setShippingType("Type");
        shipping.setDestinationId("1");
        shipping.setDiscountApplied("12");
        shipping.setFinalPrice(0.0);
        shipping.setGuideNumber("123123123123");
        shipping.setQuantityProduct(10000);
        shipping.setRegistrationDate(LocalDate.now());
        shipping.setVehicleNumber("123435");

        return shipping;
    }
}