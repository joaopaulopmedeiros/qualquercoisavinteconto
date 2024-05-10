package com.github.qualquercoisavinteconto.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.dto.AdsDTO;
import com.github.qualquercoisavinteconto.models.Ads;
import com.github.qualquercoisavinteconto.models.Product;
import com.github.qualquercoisavinteconto.repositories.AdsRepository;
import com.github.qualquercoisavinteconto.services.AdsService;
import com.github.qualquercoisavinteconto.services.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService{
  
  private final AdsRepository adsRepository;
  private final ProductService productService;

  @Override
  public Ads save(AdsDTO adsDTO) {
    Ads ads = new Ads();
    Product product = productService.findById(adsDTO.getProduct_id());
    ads.setProduct(product);
    ads.setDescription(adsDTO.getDescription());
    return adsRepository.save(ads);
  }

  @Override
  public Ads findById(Long id) {
    return adsRepository.findById(id).orElseThrow(() -> new RuntimeException("Ads not found"));
  }

  @Override
  public List<Ads> findAll() {
    return adsRepository.findAll();
  }

  @Override
  public Ads findByProductId(Long id) {
    return adsRepository.findByProduct_id(id).orElseThrow(() -> new RuntimeException("Ads not found"));
  }

  @Override
  public void delete(Long id) {
    adsRepository.deleteById(id);
  }

}