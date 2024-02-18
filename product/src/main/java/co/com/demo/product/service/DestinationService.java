package co.com.demo.product.service;

import co.com.demo.product.model.Destination;
import co.com.demo.product.object.DestinationDto;
import co.com.demo.product.repository.DestinationRepository;
import co.com.demo.product.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public DestinationDto save(DestinationDto destinationDto) {
        destinationDto.setDestinationId(Utilities.id());
        destinationRepository.save(mapperToModel(destinationDto));
        return destinationDto;
    }

    public DestinationDto update(DestinationDto destinationDto) {
        destinationRepository.save(mapperToModel(destinationDto));
        return destinationDto;
    }

    public DestinationDto findById(String id) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);

        if (optionalDestination.isPresent()) {
            return mapperToDto(optionalDestination.get());
        }
        return null;
    }

    public List<DestinationDto> findAll() {
        return destinationRepository.findAll().stream()
                .map(this::mapperToDto)
                .collect(Collectors.toList());
    }

    private DestinationDto mapperToDto(Destination destination) {

        DestinationDto destinationDto = new DestinationDto();
        destinationDto.setDestinationId(destination.getDestinationId());
        destinationDto.setName(destination.getName());
        destinationDto.setLocation(destination.getLocation());
        destinationDto.setType(destination.getType());
        destinationDto.setAbility(destinationDto.getAbility());

        return destinationDto;

    }

    private Destination mapperToModel(DestinationDto destinationDto) {

        Destination destination = new Destination();
        destination.setDestinationId(destinationDto.getDestinationId());
        destination.setName(destinationDto.getName());
        destination.setLocation(destinationDto.getLocation());
        destination.setType(destinationDto.getType());
        destination.setAbility(destinationDto.getAbility());

        return destination;

    }
}
