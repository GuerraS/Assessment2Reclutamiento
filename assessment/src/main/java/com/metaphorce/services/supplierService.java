package com.metaphorce.services;


import com.metaphorce.mx.assessment.model.supplier;
import com.metaphorce.mx.assessment.repositories.supplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class supplierService
{
    HashMap<String, Object> datos;
    private final supplierRepository supplierRepository;

    @Autowired
    public supplierService (supplierRepository supplierRepository)
    {
        this.supplierRepository = supplierRepository;
    }

    public List<supplier> getsupplier ()
    {
        return this.supplierRepository.findAll();
    }

    public ResponseEntity<Object> newsupplier(supplier supplier)
    {
        Optional<supplier> res = supplierRepository.findsupplierBysupplier(supplier.getsupplier());
        datos = new HashMap<>();

        if(res.isPresent()) {
            datos.put("Error:", true);
            datos.put("Message", "Ya existe esa categoría.");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        supplierRepository.save(supplier);
        datos.put("Data", supplier);
        datos.put("Message", "La categoría ha sido insertada con éxito.");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> updatesupplier(supplier supplier, Long id)
    {
        datos = new HashMap<>();
        Optional<supplier> res = this.supplierRepository.findById(id);
        if(res.isEmpty())
        {
            datos.put("Error", true);
            datos.put("Message", "No existe una supplier con ese ID.");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        supplier oldsupplier = res.get();
        oldsupplier.setsupplier(supplier.getsupplier());
        supplierRepository.save(oldsupplier);
        datos.put("Message", "Se ha actualizado la categoría.");
        datos.put("Data", oldsupplier);
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

    public ResponseEntity<Object> deletesupplier (Long id)
    {
        datos = new HashMap<>();
        boolean existe = this.supplierRepository.existsById(id);
        if(!existe) {
            datos.put("Error", true);
            datos.put("Message", "No existe una categoría con ese ID.");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        supplierRepository.deleteById(id);
        datos.put("Message", "La categoría ha sido eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}