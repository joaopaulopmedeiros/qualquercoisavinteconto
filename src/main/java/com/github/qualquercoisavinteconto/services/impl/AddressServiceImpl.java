package com.github.qualquercoisavinteconto.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.models.User;
import com.github.qualquercoisavinteconto.models.Address;
import com.github.qualquercoisavinteconto.repositories.UserRepository;
import com.github.qualquercoisavinteconto.repositories.AddressRepository;
import com.github.qualquercoisavinteconto.services.AddressService;
import com.github.qualquercoisavinteconto.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address save(Address address)
    {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long id)
    {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> findAddressesByUser(User user)
    {
        return addressRepository.findByUser(user);
    }

    @Override
    public void delete(Long id)
    {
        addressRepository.deleteById(id);
    }
    
}
