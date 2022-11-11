package com.project.store.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  

import com.project.store.Model.Prices;
import com.project.store.Repository.PricesRepository;
import com.project.store.Requests.OrderRequest;
import com.project.store.Responses.PricesAfterTax;

@Service
public class PricesService {
    
    private static HashMap<Integer, Double> basePriceMap = new HashMap<Integer, Double>();

    private static void initialize_data(HashMap<Integer, Double> map){ //Define base prices for products
        map.put(1, 30.0);
        map.put(2, 25.99);
        map.put(3, 42.32);
    }

    @Autowired
    PricesRepository pricesRepository;

    public List<Prices> getPrices(int productId, int brandsId, LocalDateTime applicationDate) {
        
        List<Prices> prices = new ArrayList<Prices>();
        pricesRepository.getPrices(productId, brandsId, applicationDate).forEach(p -> prices.add(p));
        
        return prices;
    }

    public PricesAfterTax getFinalPrice(OrderRequest orderRequest) {

        int productId = orderRequest.getProductId();
        int brandsId = orderRequest.getBrandId();
        String applicationDateStr = orderRequest.getApplicationDate();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateStr, formatter);

        List<Prices> finalPriceList = getPrices(productId, brandsId, applicationDate);
        Prices finalPrice = finalPriceList.get(0);
        
        initialize_data(basePriceMap);
        double basePrice = basePriceMap.get(finalPrice.getBasePrice());

        double priceAfterTax = finalPrice.getPrice();
        double tax = Math.floor(((priceAfterTax - basePrice)*100 / basePrice) * 100) / 100; // calculate tax as percentage
        tax = Math.abs(tax);

        PricesAfterTax pricesAfterTax = new PricesAfterTax(
            finalPrice.getProductId(), 
            finalPrice.getBrands().getBrandsId(),
            tax,
            finalPrice.getPrice(),
            finalPrice.getStartDate(),
            finalPrice.getEndDate()
        );

        return pricesAfterTax;
    }
    
}
