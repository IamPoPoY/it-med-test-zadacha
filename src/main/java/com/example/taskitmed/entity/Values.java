package com.example.taskitmed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "values")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Values {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    // Shaxsiy identifikator
    // Собственно идентификатор
    @Column(unique = true)
    private String description;

    private String type;

}