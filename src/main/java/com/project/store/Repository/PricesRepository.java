package com.project.store.Repository;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.store.Model.Prices;

public interface PricesRepository extends CrudRepository<Prices, Integer> {

    @Query("SELECT p FROM Prices p WHERE p.productId = ?1 and p.brands.brandsId = ?2 and p.startDate <= ?3 and p.endDate >= ?3 ORDER BY p.priority DESC")
    List<Prices> getPrices(int productId, int brandsId, LocalDateTime applicationDate);
    
}
