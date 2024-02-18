package co.com.demo.product.service;

import co.com.demo.product.model.ProductType;
import co.com.demo.product.object.DestinationDto;
import co.com.demo.product.object.ProductTypeDto;
import co.com.demo.product.repository.ProductTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class ProductTypeServiceTest {
    @Mock
    ProductTypeRepository productTypeRepository;
    @InjectMocks
    ProductTypeService productTypeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        ProductTypeDto result = productTypeService.save(productTypeDtoData());
        Assertions.assertEquals(productTypeData().getDescription(), result.getDescription());
    }

    @Test
    void testUpdate() {
        ProductTypeDto result = productTypeService.update(productTypeDtoData());
        Assertions.assertEquals(productTypeData().getDescription(), result.getDescription());
    }

    @Test
    void testFindById() {
        when(productTypeRepository.findById("id")).thenReturn((Optional.of(productTypeData())));
        ProductTypeDto result = productTypeService.findById("id");
        Assertions.assertEquals(productTypeData().getDescription(), result.getDescription());
    }

    @Test
    void testFindAll() {
        List<ProductTypeDto> result = productTypeService.findAll();
        Assertions.assertNotNull(List.of(productTypeDtoData()));
    }

    private ProductTypeDto productTypeDtoData() {

        ProductTypeDto productTypeDto = new ProductTypeDto();
        productTypeDto.setDescription("Description");
        productTypeDto.setProductTypeId("1");

        return productTypeDto;
    }

    private ProductType productTypeData() {

        ProductType productType = new ProductType();
        productType.setDescription("Description");
        productType.setProductTypeId("1");

        return productType;
    }
}