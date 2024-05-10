package com.github.qualquercoisavinteconto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.dto.PurchaseItemDTO;
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

    private ProductService productService;
    private PurchaseItemRepository purchaseItemRepository;
    private PurchaseRepository purchaseRepository;

    @Override
    public void save(PurchaseItemDTO purchaseItemDTO) {
        PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.setProduct(productService.findById(purchaseItemDTO.getProduct_id()));
        purchaseItem.setQuantity(purchaseItemDTO.getQuantity());
        purchaseItem.setPurchase(purchaseRepository.findById(purchaseItemDTO.getPurchase_id()).orElse(null));
        purchaseItemRepository.save(purchaseItem);
    }
    @Override
    public void delete(Long id) {
        purchaseItemRepository.deleteById(id);
    }

    @Override
    public void update(PurchaseItemDTO purchaseItemDTO, Long id) {
        PurchaseItem purchaseItem = purchaseItemRepository.findById(id).orElse(null);
        if (purchaseItem != null) {
            purchaseItem.setProduct(productService.findById(purchaseItemDTO.getProduct_id()));
            purchaseItem.setQuantity(purchaseItemDTO.getQuantity());
            purchaseItem.setPurchase(purchaseRepository.findById(purchaseItemDTO.getPurchase_id()).orElse(null));
            purchaseItemRepository.save(purchaseItem);
        }
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

    @Override
    public List<PurchaseItem> findItemsByPurchase(Purchase purchase) {
        List<PurchaseItem> purchaseItems = purchase.getPurchaseItems();
        return purchaseItems;
    }

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
}