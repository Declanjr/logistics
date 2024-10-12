package com.auca.logistics.Model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ShipmentsRepository extends JpaRepository<Shipments, Long> {
    
    List<Shipments> findByDriver(Driver driver);
}
