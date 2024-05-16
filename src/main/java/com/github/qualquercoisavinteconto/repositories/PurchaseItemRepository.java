package com.github.qualquercoisavinteconto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.PurchaseItem;
import com.github.qualquercoisavinteconto.models.Purchase;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> 
{    
  List<PurchaseItem> findByPurchase(Purchase purchase);
}


