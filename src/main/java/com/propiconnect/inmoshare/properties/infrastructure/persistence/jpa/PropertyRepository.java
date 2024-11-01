package com.propiconnect.inmoshare.properties.infrastructure.persistence.jpa;

import com.propiconnect.inmoshare.properties.domain.model.aggregates.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository  extends JpaRepository<Property, Long > {
    List<Property> findAllByOwnerId(Long ownerId);
    /*
    Optional<Property> findByOwnerIdAndOwnerName(Long ownerId, String ownerName);
    boolean existsByOwnerIdAndOwnerName(Long ownerId, String ownerName);
    */
    Optional<Property> findByOwnerIdAndAddress(Long ownerId, String address);
    boolean existsByOwnerIdAndAddress(Long id,String address);
    boolean existsByIdAndAddressIsNot(Long id,String address);
}
