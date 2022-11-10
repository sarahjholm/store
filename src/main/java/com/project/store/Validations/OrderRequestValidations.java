package com.project.store.Validations;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class OrderRequestValidations {

    public static boolean isValidDate(String dateStr) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");        
        try {
            LocalDateTime.parse(dateStr, formatter);
        } catch (DateTimeParseException  pe) {
            return false;
        }
        return true;
    }
    
}
