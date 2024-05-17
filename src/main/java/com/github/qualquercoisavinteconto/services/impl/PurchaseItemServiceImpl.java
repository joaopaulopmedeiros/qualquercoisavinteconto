package com.github.qualquercoisavinteconto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.qualquercoisavinteconto.dto.PurchaseItemDTO;
import com.github.qualquercoisavinteconto.dto.PurchaseItemDTOwithPurchaseId;
import com.github.qualquercoisavinteconto.models.Purchase;
import com.github.qualquercoisavinteconto.models.PurchaseItem;
import com.github.qualquercoisavinteconto.repositories.PurchaseItemRepository;
import com.github.qualquercoisavinteconto.repositories.PurchaseRepository;
import com.github.qualquercoisavinteconto.services.ProductService;
import com.github.qualquercoisavinteconto.services.PurchaseItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseItemServiceImpl implements PurchaseItemService{

    private final ProductService productService;
    private final PurchaseItemRepository purchaseItemRepository;
    private final PurchaseRepository purchaseRepository;

    @Override
    @Transactional
    public PurchaseItem save(PurchaseItemDTOwithPurchaseId purchaseItemDTO) {
        PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.setProduct(productService.findById(purchaseItemDTO.getProductId()));
        purchaseItem.setQuantity(purchaseItemDTO.getQuantity());
        purchaseItem.setPurchase(purchaseRepository.findById(purchaseItemDTO.getPurchaseId()).orElse(null));
        // return purchaseItemRepository.save(purchaseItem);
        purchaseItemRepository.save(purchaseItem);
        // recalcular total de purchase
        Purchase purchase = purchaseItem.getPurchase();
        List<PurchaseItem> purchaseItems = purchase.getPurchaseItems();
        Double total = purchaseItems.stream()
            .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
            .sum();
        purchase.setTotal(total);
        purchaseRepository.save(purchase);
        return purchaseItem;
    }
    
    @Override
    public void delete(Long id) {
        purchaseItemRepository.deleteById(id);
    }

    @Override
    public PurchaseItem update(PurchaseItemDTOwithPurchaseId purchaseItemDTO, Long id) {
        PurchaseItem purchaseItem = purchaseItemRepository.findById(id).orElse(null);
        if (purchaseItem != null) {
            purchaseItem.setProduct(productService.findById(purchaseItemDTO.getProductId()));
            purchaseItem.setQuantity(purchaseItemDTO.getQuantity());
            purchaseItem.setPurchase(purchaseRepository.findById(purchaseItemDTO.getPurchaseId()).orElse(null));
            // return purchaseItemRepository.save(purchaseItem);
            purchaseItemRepository.save(purchaseItem);
            // recalcular total de purchase
            Purchase purchase = purchaseItem.getPurchase();
            List<PurchaseItem> purchaseItems = purchase.getPurchaseItems();
            Double total = purchaseItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
            purchase.setTotal(total);
            purchaseRepository.save(purchase);
            return purchaseItem;
        }
        return null;
    }

    @Override
    public void deleteAllByPurchaseId(Long purchaseId) {
        Purchase purchase = purchaseRepository.findById(purchaseId).orElse(null);
        if (purchase != null) {
            for (PurchaseItem purchaseItem : purchase.getPurchaseItems()) {
                purchaseItemRepository.deleteById(purchaseItem.getId());
            }
        }
    }

    // @Override
    // public List<PurchaseItem> findItemsByPurchase(Purchase purchase) {
    //     List<PurchaseItem> purchaseItems = purchase.getPurchaseItems();
    //     return purchaseItems;
    // }

    // @Override
    // public List<PurchaseItem> findItemsByPurchase(Purchase purchase) {
    //     List<PurchaseItem> purchaseItems = purchaseItemRepository.findByPurchase(purchase);
    //     return purchaseItems;
    // }

    @Override
    public List<PurchaseItem> findItemsByPurchaseId(Long purchaseId) {
        Purchase purchase = purchaseRepository.findById(purchaseId).orElse(null);
        if (purchase != null) {
            return purchase.getPurchaseItems();
        }
        return null;
    }

    @Override
    public Optional<PurchaseItem> findById(Long id) {
        return purchaseItemRepository.findById(id);
    }

    @Override
    public List<PurchaseItem> findAll() {
        return purchaseItemRepository.findAll();
    }
}
