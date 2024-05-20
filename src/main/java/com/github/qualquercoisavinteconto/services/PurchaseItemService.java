package com.github.qualquercoisavinteconto.services;

import java.util.List;

import com.github.qualquercoisavinteconto.dto.PurchaseItemDTO;
import com.github.qualquercoisavinteconto.dto.PurchaseItemDTOwithPurchaseId;
import com.github.qualquercoisavinteconto.exceptions.ResourceNotFoundException;
import com.github.qualquercoisavinteconto.models.PurchaseItem;

public interface PurchaseItemService {
  
  PurchaseItem save( PurchaseItemDTOwithPurchaseId purchaseItemDTO );
  void delete( Long id );
  PurchaseItem update( PurchaseItemDTO purchaseItemDTO, Long id);
  void deleteAllByPurchaseId( Long purchaseId );
  List<PurchaseItem> findItemsByPurchaseId( Long purchaseId );
  PurchaseItem findById( Long id ) throws ResourceNotFoundException;
  List<PurchaseItem> findAll();

}
