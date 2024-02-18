package co.com.demo.product.service;

import co.com.demo.product.model.Destination;
import co.com.demo.product.object.DestinationDto;
import co.com.demo.product.repository.DestinationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class DestinationServiceTest {
    @Mock
    DestinationRepository destinationRepository;
    @InjectMocks
    DestinationService destinationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        DestinationDto result = destinationService.save(destinationDtoData());
        Assertions.assertEquals("Name", result.getName());
    }

    @Test
    void testUpdate() {
        DestinationDto result = destinationService.update(destinationDtoData());
        Assertions.assertEquals("Name", result.getName());
    }

    @Test
    void testFindById() {
        when(destinationRepository.findById("id")).thenReturn((Optional.of(destinationData())));
        DestinationDto result = destinationService.findById("id");
        Assertions.assertEquals(destinationDtoData().getName(), result.getName());
    }

    @Test
    void testFindAll() {
        List<DestinationDto> result = destinationService.findAll();
        Assertions.assertNotNull(result);
    }

    private DestinationDto destinationDtoData() {

        DestinationDto destinationDto = new DestinationDto();
        destinationDto.setDestinationId("1");
        destinationDto.setName("Name");
        destinationDto.setLocation("Location");
        destinationDto.setType("Type");
        destinationDto.setAbility("Ability");

        return destinationDto;

    }

    private Destination destinationData() {

        Destination destination = new Destination();
        destination.setDestinationId("1");
        destination.setName("Name");
        destination.setLocation("Location");
        destination.setType("Type");
        destination.setAbility("Ability");

        return destination;

    }


}