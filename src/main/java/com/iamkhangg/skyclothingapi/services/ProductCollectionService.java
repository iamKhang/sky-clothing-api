package com.iamkhangg.skyclothingapi.services;

import java.util.List;

import com.iamkhangg.skyclothingapi.dtos.base.BaseCollectionDTO;
import com.iamkhangg.skyclothingapi.repositories.ProductCollectionRepository;
import lombok.RequiredArgsConstructor;


public interface ProductCollectionService {
    List<BaseCollectionDTO> getCollections();
}
