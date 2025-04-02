package com.project.project.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "medicamentos")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedicamento")
    private Long id;
    @Column(name = "nombre") // En BD es "nombre"
    private String name; // En código es "name"
    @Column(name = "precio")
    private Double price;
    @Column(name = "cantidad")
    private int quantity;
   
}
