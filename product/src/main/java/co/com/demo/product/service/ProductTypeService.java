package co.com.demo.product.service;

import co.com.demo.product.model.ProductType;
import co.com.demo.product.object.ProductTypeDto;
import co.com.demo.product.repository.ProductTypeRepository;
import co.com.demo.product.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductTypeService {
    
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public ProductTypeDto save(ProductTypeDto productTypeDto) {
        productTypeDto.setProductTypeId(Utilities.id());
        productTypeRepository.save(mapperToModel(productTypeDto));
        return productTypeDto;
    }

    public ProductTypeDto update(ProductTypeDto productTypeDto) {
        productTypeRepository.save(mapperToModel(productTypeDto));
        return productTypeDto;
    }

    public ProductTypeDto findById(String id) {
        Optional<ProductType> optionalClient = productTypeRepository.findById(id);

        if (optionalClient.isPresent()) {
            return mapperToDto(optionalClient.get());
        }
        return null;
    }

    public List<ProductTypeDto> findAll() {
        return productTypeRepository.findAll().stream()
                .map(this::mapperToDto)
                .collect(Collectors.toList());
    }

    private ProductTypeDto mapperToDto(ProductType productType) {

        ProductTypeDto productTypeDto = new ProductTypeDto();
        productTypeDto.setDescription(productTypeDto.getDescription());
        productTypeDto.setProductTypeId(productTypeDto.getProductTypeId());

        return productTypeDto;

    }

    private ProductType mapperToModel(ProductTypeDto productTypeDto) {

        ProductType productType = new ProductType();
        productType.setDescription(productTypeDto.getDescription());
        productType.setProductTypeId(productTypeDto.getProductTypeId());

        return productType;

    }
    
    
}
