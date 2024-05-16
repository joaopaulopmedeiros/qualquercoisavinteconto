package com.github.qualquercoisavinteconto.services;

import java.util.List;
import java.util.Optional;

import com.github.qualquercoisavinteconto.models.Purchase;
import com.github.qualquercoisavinteconto.models.User;
import com.github.qualquercoisavinteconto.dto.PurchaseDTO;
import com.github.qualquercoisavinteconto.enums.PurchaseStatus;

public interface PurchaseService {
  
  Purchase save( PurchaseDTO purchaseDTO );
  Optional<Purchase> findById( Long id );
  List<Purchase> findPurchasesByUser( User user );
  List<Purchase> findAll();
  void updateStatus( Long id, PurchaseStatus status );
  void delete( Long id );
  Purchase update( PurchaseDTO purchaseDTO, Long id );

}
