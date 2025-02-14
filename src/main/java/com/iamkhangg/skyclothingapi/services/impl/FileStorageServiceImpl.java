package com.iamkhangg.skyclothingapi.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.text.Normalizer;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.iamkhangg.skyclothingapi.services.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Value("${file.base-url}")
    private String baseUrl;

    private String createSlug(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String slug = pattern.matcher(normalized).replaceAll("")
                .toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-");
        return slug;
    }

    private Path getProductUploadPath(String productSlug) {
        Path uploadPath = Paths.get(uploadDir, productSlug);
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                throw new RuntimeException("Could not create upload directory!", e);
            }
        }
        return uploadPath;
    }

    private int getNextFileNumber(Path directoryPath) throws IOException {
        if (!Files.exists(directoryPath)) {
            return 1;
        }

        try (var files = Files.list(directoryPath)) {
            return (int) files
                    .filter(Files::isRegularFile)
                    .count() + 1;
        }
    }

    @Override
    public String storeFile(MultipartFile file, String productName) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        String productSlug = createSlug(productName);
        
        Path productPath = getProductUploadPath(productSlug);
        int nextNumber = getNextFileNumber(productPath);
        
        // Create filename with next order number
        String newFileName = String.format("%03d%s", nextNumber, fileExtension);
        
        Path targetLocation = productPath.resolve(newFileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        
        return baseUrl + "/images/products/" + productSlug + "/" + newFileName;
    }

    @Override
    public List<String> storeMultipleFiles(MultipartFile[] files, String productName) throws IOException {
        List<String> fileUrls = new ArrayList<>();
        String productSlug = createSlug(productName);
        Path productPath = getProductUploadPath(productSlug);
        
        int startNumber = getNextFileNumber(productPath);
        
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String fileExtension = fileName.substring(fileName.lastIndexOf("."));
            
            // Create filename with order number starting from the next available number
            String newFileName = String.format("%03d%s", startNumber + i, fileExtension);
            
            Path targetLocation = productPath.resolve(newFileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
            fileUrls.add(baseUrl + "/images/products/" + productSlug + "/" + newFileName);
        }
        return fileUrls;
    }

    @Override
    public void deleteFile(String fileName) throws IOException {
        Path filePath = getProductUploadPath(createSlug(fileName)).resolve(fileName);
        Files.deleteIfExists(filePath);
    }
} 