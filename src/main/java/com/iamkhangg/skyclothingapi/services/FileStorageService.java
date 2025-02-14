package com.iamkhangg.skyclothingapi.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String storeFile(MultipartFile file, String productName) throws IOException;
    List<String> storeMultipleFiles(MultipartFile[] files, String productName) throws IOException;
    void deleteFile(String fileName) throws IOException;
} 