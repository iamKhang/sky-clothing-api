package com.iamkhangg.skyclothingapi.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class BaseCollectionDTO {
    private String collectionId;
    private String collectionName;

    @Override
    public String toString() {
        return "BaseCollectionDTO{" +
                "collectionId='" + collectionId + '\'' +
                ", collectionName='" + collectionName + '\'' +
                '}';
    }
}
