package com.example.taskitmed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Identifier identifier;

    // BEMOR
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // SHIFOKOR
    @ManyToOne
    @JoinColumn(name = "practitioner_id")
    private Practitioner practitioner;

    // Tashkilot yoki Shifoxona
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
