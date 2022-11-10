package com.project.store.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.Requests.OrderRequest;
import com.project.store.Responses.PricesAfterTax;
import com.project.store.Service.PricesService;
import com.project.store.Validations.OrderRequestValidations;

@RequestMapping(value = "/store")
@RestController
public class PricesController {

    @Autowired
    PricesService pricesService;

    @GetMapping("/finalPrice")
    private ResponseEntity<PricesAfterTax> getFinalPrice(@Valid @RequestBody OrderRequest orderRequest) {

        String applicationDateStr = orderRequest.getApplicationDate();

        if(!OrderRequestValidations.isValidDate(applicationDateStr)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PricesAfterTax finalPrice = pricesService.getFinalPrice(orderRequest);

        return new ResponseEntity<>(finalPrice, HttpStatus.OK);
    }
    
}
