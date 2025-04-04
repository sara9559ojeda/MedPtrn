package com.project.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.project.entity.Medicine;
import com.project.project.service.MedicineService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(path = "api/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public ResponseEntity<List<Medicine>> getAll() {
        return ResponseEntity.ok(medicineService.getMedicine());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getById(@PathVariable("id") Long id) {
        Optional<Medicine> medicine = medicineService.getMedicine(id);
        return medicine.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Medicine medicine) {
        if (medicine.getName() == null || medicine.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Medicine name cannot be empty");
        }
        if (medicine.getPrice() == null || medicine.getPrice() <= 0) {
            return ResponseEntity.badRequest().body("Price must be greater than zero");
        }
        if (medicine.getQuantity() < 0) {
            return ResponseEntity.badRequest().body("Quantity cannot be negative");
        }
        medicineService.save(medicine);
        return ResponseEntity.status(HttpStatus.CREATED).body("Medicine added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Medicine medicine) {
        try {
            medicineService.update(id, medicine);
            return ResponseEntity.ok("Medicine updated successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!medicineService.getMedicine(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicine not found with id: " + id);
        }
        medicineService.delete(id);
        return ResponseEntity.ok("Medicine deleted successfully");
    }
}
