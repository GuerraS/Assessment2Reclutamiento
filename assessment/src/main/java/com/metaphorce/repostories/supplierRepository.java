
package com.metaphorce.repositories;


import com.metaphorce.mx.assessment.model.supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface supplierRepository extends JpaRepository<supplier,Long> {

    Optional<supplier> findsupplierBysupplier(String supplier);
}