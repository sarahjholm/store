package com.project.store.Requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    @Min(value = 1, message = "Product ID is invalid")
    private int productId;

    @Min(value = 1, message = "Brand ID is invalid")
    private int brandId;

    @NotEmpty(message = "Order date must be filled out")
    @Size(min=19, max=19, message = "Your date is incomplete")
    private String applicationDate;
    
}
