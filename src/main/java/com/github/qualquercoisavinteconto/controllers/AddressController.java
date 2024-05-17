package com.github.qualquercoisavinteconto.controllers;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.github.qualquercoisavinteconto.services.AddressService;
import com.github.qualquercoisavinteconto.services.UserService;
import com.github.qualquercoisavinteconto.models.Address;
import com.github.qualquercoisavinteconto.dto.AddressDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@Tag(name = "Address")
@RequestMapping("/address")
public class AddressController {
    private final UserService userService;
    private final AddressService addressService;

    public AddressController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address save(@RequestBody AddressDTO addressDTO) {
        Address address = new Address();
        address.setCity(addressDTO.getCity());
        address.setNumber(addressDTO.getNumber());
        address.setState(addressDTO.getState());
        address.setStreet(addressDTO.getStreet());
        address.setUser(userService.findById(addressDTO.getUserId()));
        return addressService.save(address);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Long id) {
        Address address = addressService.findById(id);
        if(address == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found");
        }
        return ResponseEntity.ok(address);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getAddressByUser(@PathVariable Long id) {
        List<Address> addresses = addressService.findAddressesByUser(userService.findById(id));
        if(addresses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found");
        }
        return ResponseEntity.ok(addresses);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        Address address = addressService.findById(id);
        if(address == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found");
        }
        addressService.delete(id);
        return ResponseEntity.ok("Address deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        Address address = addressService.findById(id);
        if(address == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found");
        }
        address.setCity(addressDTO.getCity());
        address.setNumber(addressDTO.getNumber());
        address.setState(addressDTO.getState());
        address.setStreet(addressDTO.getStreet());
        address.setUser(userService.findById(addressDTO.getUserId()));
        return ResponseEntity.ok(addressService.save(address));
    }
    
}