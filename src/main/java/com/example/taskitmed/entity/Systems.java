package com.example.taskitmed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "systems")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Systems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String type;

    // Ushbu identifikatorni tayinlagan tizimning URL manzili
    // URL системы, присвоившей данный идентифицикатор
    private String description;

}