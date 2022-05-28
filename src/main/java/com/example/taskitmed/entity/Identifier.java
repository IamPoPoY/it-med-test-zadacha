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
    private Long id;

    // Boshqa tizim tomonidan tayinlangan manzil identifikatori (core.fhir.uz emas)
    // Идентификатор назначения, присвоенный другой системой (не core.fhir.uz)
    private String descriptions;

    private Object object;

    @OneToOne
    @JoinColumn(name = "system_id")
    private Systems system;

    @OneToOne
    @JoinColumn(name = "values_id")
    private Values values;

}
