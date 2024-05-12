package com.github.qualquercoisavinteconto.services;

import java.util.List;

import com.github.qualquercoisavinteconto.models.Address;
import com.github.qualquercoisavinteconto.models.User;

public interface AddressService {

    Address save(Address address);
    Address findById(Long id);
    List<Address> findAddressesByUser(User user);
    void delete(Long id);

} 

