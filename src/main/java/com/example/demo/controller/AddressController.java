package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/v1")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddress() {
        return new ResponseEntity<>(addressService.getAllAddress(), HttpStatus.OK);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        System.out.println(id);
        return new ResponseEntity<>(addressService.getAddressById(id), HttpStatus.OK);
    }

    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(addressService.createAddress(addressDto), HttpStatus.CREATED);
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id) {
        return new ResponseEntity<>("Update address id " + id.toString(), HttpStatus.OK);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        return new ResponseEntity<>("Delete address id " + id.toString(), HttpStatus.NO_CONTENT);
    }
}
