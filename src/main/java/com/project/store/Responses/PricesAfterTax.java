package com.project.store.Responses;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PricesAfterTax {

    private int productId;
    private int brandsId;
    private double tax;
    private double finalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    
}
