package co.com.demo.product.service;

import co.com.demo.product.exception.BadRequestException;
import co.com.demo.product.model.Shipping;
import co.com.demo.product.object.DestinationDto;
import co.com.demo.product.object.ShippingDto;
import co.com.demo.product.repository.DestinationRepository;
import co.com.demo.product.repository.ShippingRepository;
import co.com.demo.product.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private DestinationService destinationService;

    public ShippingDto save(ShippingDto shippingDto) {
        shippingDto.setShippingId(Utilities.id());
        shippingDto.setGuideNumber(Utilities.codeGenerate());
        shippingDto.setShippingType(destinationService.findById(shippingDto.getDestinationId()).getType());

        validateData(shippingDto);

        shippingDto = calculateDiscount(shippingDto);

        shippingRepository.save(mapperToModel(shippingDto));
        return shippingDto;
    }

    public ShippingDto update(ShippingDto shippingDto) {

        validateData(shippingDto);

        shippingDto = calculateDiscount(shippingDto);

        shippingRepository.save(mapperToModel(shippingDto));
        return shippingDto;
    }

    public ShippingDto findById(String id) {
        Optional<Shipping> optionalShipping = shippingRepository.findById(id);

        if (optionalShipping.isPresent()) {
            return mapperToDto(optionalShipping.get());
        }
        return null;
    }

    public List<ShippingDto> findAll() {
        return shippingRepository.findAll().stream()
                .map(this::mapperToDto)
                .collect(Collectors.toList());
    }

    private ShippingDto mapperToDto(Shipping shipping) {

        ShippingDto shippingDto = new ShippingDto();
        shippingDto.setShippingId(shipping.getShippingId());
        shippingDto.setPriceShipping(shipping.getPriceShipping());
        shippingDto.setClientId(shipping.getClientId());
        shippingDto.setDeliverDate(shipping.getDeliverDate());
        shippingDto.setShippingType(shipping.getShippingType());
        shippingDto.setDestinationId(shipping.getDestinationId());
        shippingDto.setDiscountApplied(shipping.getDiscountApplied());
        shippingDto.setFinalPrice(shipping.getFinalPrice());
        shippingDto.setGuideNumber(shipping.getGuideNumber());
        shippingDto.setQuantityProduct(shipping.getQuantityProduct());
        shippingDto.setRegistrationDate(shipping.getRegistrationDate());
        shippingDto.setVehicleNumber(shipping.getVehicleNumber());


        return shippingDto;

    }

    private Shipping mapperToModel(ShippingDto shippingDto) {

        Shipping shipping = new Shipping();
        shipping.setShippingId(shippingDto.getShippingId());
        shipping.setPriceShipping(shippingDto.getPriceShipping());
        shipping.setClientId(shippingDto.getClientId());
        shipping.setDeliverDate(shippingDto.getDeliverDate());
        shipping.setShippingType(shippingDto.getShippingType());
        shipping.setDestinationId(shippingDto.getDestinationId());
        shipping.setDiscountApplied(shippingDto.getDiscountApplied());
        shipping.setFinalPrice(shippingDto.getFinalPrice());
        shipping.setGuideNumber(shippingDto.getGuideNumber());
        shipping.setQuantityProduct(shippingDto.getQuantityProduct());
        shipping.setRegistrationDate(shippingDto.getRegistrationDate());
        shipping.setVehicleNumber(shippingDto.getVehicleNumber());

        return shipping;

    }

    private void validateData(ShippingDto shippingDto) {

        if (shippingDto.getShippingType().equals(Utilities.LAND)) {
            if (!Utilities.vehicleNumberValidate(shippingDto.getVehicleNumber())) {
                throw new BadRequestException("Placa del vehiculo incorrecta");
            }
        }

        if (shippingDto.getShippingType().equals(Utilities.MARITIME)) {
            if (!Utilities.shipNumberValidate(shippingDto.getVehicleNumber())) {
                throw new BadRequestException("Placa del vehiculo incorrecta");
            }
        }

    }

    private ShippingDto calculateDiscount(ShippingDto shippingDto) {

        double discount = 0.0;

        if (shippingDto.getQuantityProduct() > 10) {
            if (shippingDto.getShippingType().equals(Utilities.LAND)) {
                discount = shippingDto.getPriceShipping() * 0.05;
            } else if (shippingDto.getShippingType().equals(Utilities.MARITIME)) {
                discount = shippingDto.getPriceShipping() * 0.03;
            }
        }

        shippingDto.setFinalPrice(shippingDto.getPriceShipping() - discount);
        shippingDto.setDiscountApplied(String.valueOf(discount));
        return shippingDto;
    }
}
