package com.example.taskitmed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Identifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Boshqa tizim tomonidan tayinlangan manzil identifikatori (core.fhir.uz emas)
    // Идентификатор назначения, присвоенный другой системой (не core.fhir.uz)
    @Column(unique = true)
    private String systemUrl;

    // shaxsiy raqam
    @Column(unique = true)
    private String values;

}
