package com.scaler.yash.productservice13april.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseModel {
    @Id
    private Integer id;
    private Date createdAt;
    private Date updatedAt;
}
