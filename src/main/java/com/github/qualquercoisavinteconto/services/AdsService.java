package com.github.qualquercoisavinteconto.services;

import java.util.List;

import com.github.qualquercoisavinteconto.dto.AdsDTO;
import com.github.qualquercoisavinteconto.models.Ads;

public interface AdsService {
  
  Ads save(AdsDTO adsDTO);
  Ads findById(Long id);
  List<Ads> findAll();
  Ads findByProductId(Long id);
  void delete(Long id);
  Ads update(Long id, AdsDTO adsDTO);

}
