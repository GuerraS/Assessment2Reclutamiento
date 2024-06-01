package com.metaphorce.controllers;

import com.metaphorce.mx.assessment.model.supplier;
import com.metaphorce.mx.assessment.services.supplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplier")
public class supplierController {
    private final supplierService supplierService;

    @Autowired
    public supplierController (supplierService supplierService)
    {
        this.supplierService = supplierService;
    }

    @GetMapping("/all")
    public List<supplier> getsupplier()
    {
        return this.supplierService.getsupplier();
    }


    @PostMapping("/add")
    public ResponseEntity<Object> registrarsupplier (@RequestBody supplier supplier)
    {
        return this.supplierService.newsupplier(supplier);
    }

    @PutMapping("/update/{supplierID}")
    public ResponseEntity<Object> actualizarsupplier (@RequestBody supplier supplier, @PathVariable("supplierID") Long id)
    {
        return this.supplierService.updatesupplier(supplier, id);
    }

    @DeleteMapping(path = "/delete/{supplierID}")
    public ResponseEntity<Object> eliminarsupplier(@PathVariable("supplierID") Long id)
    {
        return this.supplierService.deletesupplier(id);
    }
}