package com.project.project.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project.entity.Medicine;
import com.project.project.repository.MedicineRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MedicineService {
    @Autowired
    MedicineRepository medicineRepository;
    public List<Medicine> getMedicine() {
        return medicineRepository.findAll();
    }
    public Optional<Medicine> getMedicine(Long id) {
        return medicineRepository.findById(id);
    }
    public void save(Medicine medicine) {
        medicineRepository.save(medicine);

    }
    public void update(Long id, Medicine updatedMedicine) {
        if (medicineRepository.existsById(id)) {
            updatedMedicine.setId(id);
            medicineRepository.save(updatedMedicine);
        } else {
            throw new EntityNotFoundException("Medicine not found with id: " + id);
        }
    }
    public void delete(Long id) {
        medicineRepository.deleteById(id);
    }
}
