package com.github.qualquercoisavinteconto.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

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

import com.github.qualquercoisavinteconto.dto.AdsDTO;
import com.github.qualquercoisavinteconto.dto.ReviewDTO;
import com.github.qualquercoisavinteconto.exceptions.ResourceNotFoundException;
import com.github.qualquercoisavinteconto.models.Address;
import com.github.qualquercoisavinteconto.models.Ads;
import com.github.qualquercoisavinteconto.services.AdsService;
import com.github.qualquercoisavinteconto.services.impl.AdsServiceImpl;



@RestController
@Tag(name = "Ads")
@RequestMapping("ads")
public class AdsController {

    
    @Autowired
    AdsServiceImpl adsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ads save(@RequestBody AdsDTO adsDTO) {
        return adsService.save(adsDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAdsById(@PathVariable Long id) {
        Ads ads = adsService.findById(id);
        if(ads == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ads not found");
        }
        return ResponseEntity.ok(ads);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody AdsDTO adsDTO) throws ResourceNotFoundException {
        adsService.update(id, adsDTO);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAds(@PathVariable Long id) {
        Ads ads = adsService.findById(id);
        if(ads == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ads not found");
        }
        adsService.delete(id);
        return ResponseEntity.ok("Ads deleted");
    }

}