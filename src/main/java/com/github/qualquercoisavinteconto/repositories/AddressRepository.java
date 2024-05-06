package com.github.qualquercoisavinteconto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.Address;
import com.github.qualquercoisavinteconto.models.User;

public interface AddressRepository extends JpaRepository<Address, Long>{

  List<Address> findByUser(User user);
  
}
