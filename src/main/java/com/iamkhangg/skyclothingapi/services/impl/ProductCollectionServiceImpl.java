package com.iamkhangg.skyclothingapi.services.impl;

import com.iamkhangg.skyclothingapi.dtos.base.BaseCollectionDTO;
import com.iamkhangg.skyclothingapi.repositories.ProductCollectionRepository;
import com.iamkhangg.skyclothingapi.services.ProductCollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductCollectionServiceImpl implements ProductCollectionService {

    private final ProductCollectionRepository productCollectionRepository;

    @Override
    public List<BaseCollectionDTO> getCollections() {
        return productCollectionRepository.findAll().stream()
                .map(collection -> BaseCollectionDTO.builder()
                        .collectionId(collection.getCollectionId())
                        .collectionName(collection.getCollectionName())
                        .build())
                .collect(Collectors.toList());
    }
}
