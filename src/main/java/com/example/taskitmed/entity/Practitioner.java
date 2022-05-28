package com.example.taskitmed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "practitioner")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Practitioner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String fullName;

    // Retseptni yozgan shifokorning asosiy biznes identifikatori
    // Основной бизнес идентификатор врача, который выписал назначение
    private String description;

    private String type;

}