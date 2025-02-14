package com.iamkhangg.skyclothingapi.dtos.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadResponseDTO {
    private String fileName;
    private String fileUrl;
    private String message;

    @Override
    public String toString() {
        return "FileUploadResponseDTO{" +
                "fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
} 