package com.github.qualquercoisavinteconto.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.dto.PurchaseItemDTO;
import com.github.qualquercoisavinteconto.dto.PurchaseItemDTOwithPurchaseId;
import com.github.qualquercoisavinteconto.models.Purchase;
import com.github.qualquercoisavinteconto.models.PurchaseItem;
import com.github.qualquercoisavinteconto.services.PurchaseItemService;
import com.github.qualquercoisavinteconto.services.PurchaseService;

@RestController
@Tag(name = "PurchaseItem")
@RequestMapping("/purchases-items")
public class PurchaseItemController {

  @Autowired
  private PurchaseItemService purchaseItemService;
  @Autowired
  private PurchaseService purchaseService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PurchaseItem save(@RequestBody PurchaseItemDTOwithPurchaseId purchaseItemDTO) {
    return purchaseItemService.save(purchaseItemDTO);
  }

  @GetMapping
  public ResponseEntity<?> getPurchaseItems() {
    List<PurchaseItem> purchaseItems = purchaseItemService.findAll();
    if(purchaseItems.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No purchase items found");
    }
    return ResponseEntity.ok(purchaseItems);
  }

  @GetMapping("{id}")
  public ResponseEntity<?> getPurchaseItemById(@PathVariable Long id) {
    Optional<PurchaseItem> purchaseItem = purchaseItemService.findById(id);
    if(purchaseItem.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchase item not found");
    }
    return ResponseEntity.ok(purchaseItem);
  }

  @GetMapping("/purchase/{id}")
  public ResponseEntity<?> getPurchaseItemsByPurchaseId(@PathVariable Long id) {
    Optional<Purchase> purchase = purchaseService.findById(id);
    if(purchase.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchase not found");
    }
    List<PurchaseItem> purchaseItems = purchaseItemService.findItemsByPurchaseId(id);
    if(purchaseItems.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No purchase items found for this purchase");
    }
    return ResponseEntity.ok(purchaseItems);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deletePurchaseItem(@PathVariable Long id) {
    Optional<PurchaseItem> purchaseItem = purchaseItemService.findById(id);
    if(purchaseItem.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchase item not found");
    }
    purchaseItemService.delete(id);
    return ResponseEntity.ok("Purchase item deleted");
  }

  @DeleteMapping("/purchase/{id}")
  public ResponseEntity<?> deletePurchaseItemsByPurchaseId(@PathVariable Long id) {
    Optional<Purchase> purchase = purchaseService.findById(id);
    if(purchase.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchase not found");
    }
    purchaseItemService.deleteAllByPurchaseId(id);
    return ResponseEntity.ok("Purchase items deleted");
  }

  @PutMapping("{id}")
  public ResponseEntity<?> updatePurchaseItem(@PathVariable Long id, @RequestBody PurchaseItemDTO purchaseItemDTO) {
    Optional<PurchaseItem> purchaseItem = purchaseItemService.findById(id);
    if(purchaseItem.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchase item not found");
    }
    return ResponseEntity.ok(purchaseItemService.update(purchaseItemDTO, id));
  }
    
}