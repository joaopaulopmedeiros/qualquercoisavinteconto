package com.github.qualquercoisavinteconto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.PurchaseItem;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> 
{    
}


