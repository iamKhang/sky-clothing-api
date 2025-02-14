package com.iamkhangg.skyclothingapi.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iamkhangg.skyclothingapi.dtos.file.FileUploadResponseDTO;
import com.iamkhangg.skyclothingapi.services.FileStorageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {

    private final FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<FileUploadResponseDTO> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("productName") String productName) {
        try {
            String fileUrl = fileStorageService.storeFile(file, productName);
            FileUploadResponseDTO response = new FileUploadResponseDTO(
                file.getOriginalFilename(),
                fileUrl,
                "File uploaded successfully"
            );
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.badRequest()
                .body(new FileUploadResponseDTO(null, null, "Failed to upload file: " + e.getMessage()));
        }
    }

    @PostMapping("/upload-multiple")
    public ResponseEntity<List<FileUploadResponseDTO>> uploadMultipleFiles(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("productName") String productName) {
        try {
            List<String> fileUrls = fileStorageService.storeMultipleFiles(files, productName);
            List<FileUploadResponseDTO> responses = fileUrls.stream()
                .map(url -> new FileUploadResponseDTO(null, url, "File uploaded successfully"))
                .collect(Collectors.toList());
            return ResponseEntity.ok(responses);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 