package com.github.qualquercoisavinteconto.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.github.qualquercoisavinteconto.services.AddressService;
import com.github.qualquercoisavinteconto.services.UserService;
import com.github.qualquercoisavinteconto.models.Address;
import com.github.qualquercoisavinteconto.dto.AddressDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;


@RestController
@Tag(name = "Address")
@RequestMapping("/address")
public class AddressController {
    // private final ProductService service;

    // public AddressController(ProductService service) {
    //     this.service = service;
    // }

    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address save(@RequestBody AddressDTO addressDTO) {
        Address address = new Address();
        address.setCity(addressDTO.getCity());
        address.setNumber(addressDTO.getNumber());
        address.setState(addressDTO.getState());
        address.setStreet(addressDTO.getStreet());
        address.setUser(userService.findById(addressDTO.getUser_id()));
        return addressService.save(address);
    }





}