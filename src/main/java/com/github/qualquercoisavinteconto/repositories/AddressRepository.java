package com.github.qualquercoisavinteconto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

  List<Address> findByUser(User user);
  
}
