package com.github.qualquercoisavinteconto.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.dto.PurchaseDTO;
import com.github.qualquercoisavinteconto.models.Purchase;
import com.github.qualquercoisavinteconto.models.User;
import com.github.qualquercoisavinteconto.services.PurchaseService;
import com.github.qualquercoisavinteconto.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@Tag(name = "Purchase")
@RequestMapping("/purchases")
public class PurchaseController {

  private final PurchaseService purchaseService;
  private UserService userService;

  public PurchaseController(PurchaseService purchaseService, UserService userService)
  {
    this.purchaseService = purchaseService;
    this.userService = userService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Purchase save(@RequestBody PurchaseDTO purchaseDTO) {
    return purchaseService.save(purchaseDTO);
  }

  @GetMapping
  public ResponseEntity<?> getPurchases() {
    List<Purchase> purchases = purchaseService.findAll();
    if(purchases.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No purchases found");
    }
    return ResponseEntity.status(HttpStatus.OK).body(purchases);
  }

  @GetMapping("{id}")
  public ResponseEntity<?> getPurchaseById(@PathVariable Long id) {
    Optional<Purchase> purchase = purchaseService.findById(id);
    if(purchase.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchase not found");
    }
    return ResponseEntity.status(HttpStatus.OK).body(purchase);
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<?> getPurchasesByUser(@PathVariable Long id) {
    User user = userService.findById(id);
    if(user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
    List<Purchase> purchases = purchaseService.findPurchasesByUser(user);
    if(purchases.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No purchases found");
    }
    return ResponseEntity.status(HttpStatus.OK).body(purchases);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deletePurchase(@PathVariable Long id) {
    Optional<Purchase> purchase = purchaseService.findById(id);
    if(purchase.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchase not found");
    }
    purchaseService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Purchase deleted");
  }

  @PutMapping("{id}")
  public ResponseEntity<?> updatePurchase(@PathVariable Long id, @RequestBody PurchaseDTO purchaseDTO) {
    Optional<Purchase> purchase = purchaseService.findById(id);
    if(purchase.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchase not found");
    }
    return ResponseEntity.ok(purchaseService.update(purchaseDTO, id));
  }
  
}