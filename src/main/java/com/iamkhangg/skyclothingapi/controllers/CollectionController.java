package com.iamkhangg.skyclothingapi.controllers;

import com.iamkhangg.skyclothingapi.dtos.base.BaseCollectionDTO;
import com.iamkhangg.skyclothingapi.services.ProductCollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/collections")
@RequiredArgsConstructor
public class CollectionController {
    private final ProductCollectionService collectionService;

    @GetMapping("")
    public ResponseEntity<List<BaseCollectionDTO>> getCollections() {
        List<BaseCollectionDTO> collections = collectionService.getCollections();
        return ResponseEntity.ok(collections);
    }
}
