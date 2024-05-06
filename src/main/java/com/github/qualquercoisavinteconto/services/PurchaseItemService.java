package com.github.qualquercoisavinteconto.services;

import java.util.List;
import java.util.Optional;

import com.github.qualquercoisavinteconto.dto.PurchaseItemDTO;
import com.github.qualquercoisavinteconto.models.Purchase;
import com.github.qualquercoisavinteconto.models.PurchaseItem;

public interface PurchaseItemService {
  
  // void save( PurchaseItemDTO purchaseItemDTO );
  void delete( Long id );
  void deleteAllByPurchaseId( Long purchaseId );
  List<PurchaseItem> findItemsByPurchase( Purchase purchase );
  List<PurchaseItem> findItemsByProductId( Long productId );
  List<PurchaseItem> findItemsByPurchaseId( Long purchaseId );
  Optional<PurchaseItem> findById( Long id );

}
