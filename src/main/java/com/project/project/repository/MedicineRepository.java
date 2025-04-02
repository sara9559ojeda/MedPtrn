package com.project.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.project.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    
}
