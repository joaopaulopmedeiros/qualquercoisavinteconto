package com.github.qualquercoisavinteconto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.Ads;

public interface AdsRepository extends JpaRepository<Ads, Long> 
{    
    Optional<Ads> findByProductId(Long id);
}
