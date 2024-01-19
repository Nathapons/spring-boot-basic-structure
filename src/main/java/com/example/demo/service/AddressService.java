package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.IAddressRepository;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    IAddressRepository iAddressRepository;

    @Autowired
    IUserRepository iUserRepository;

    public List<Address> getAllAddress() {
        return (List<Address>) iAddressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        Optional<Address> unwarpAddress = iAddressRepository.findById(id);
        if (unwarpAddress.isPresent()) {
            return unwarpAddress.get();
        } else {
            throw new NotFoundException("Address id %s is not found");
        }
    }

    public Address createAddress(AddressDto addressDto) {
        Long userId = addressDto.getUser();
        Optional<User> unwrapUser = iUserRepository.findById(userId);

        if (unwrapUser.isPresent()) {
            User wrapUser  = unwrapUser.get();
            Address address = new Address();

            address.setStreet(addressDto.getStreet());
            address.setCity(addressDto.getCity());
            address.setZipCode(addressDto.getZipCode());
            address.setUser(wrapUser);

            return iAddressRepository.save(address);
        } else {
            throw new NotFoundException(String.format("User id %s is not found", userId));
        }
    }
}
