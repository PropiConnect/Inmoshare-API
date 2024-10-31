package com.propiconnect.inmoshare.payments.infrastructure.persistence.jpa;

import com.propiconnect.inmoshare.payments.domain.model.aggregates.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Puedes agregar métodos de consulta personalizados aquí si se necesitan en el futuro
}
