package com.propiconnect.inmoshare.user.infrastructure.persistence.jpa;

import com.propiconnect.inmoshare.user.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id );
}
