package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAddressRepository extends CrudRepository<Address, Long> {
    Optional<Address> findAddressByUser(User user);
}
