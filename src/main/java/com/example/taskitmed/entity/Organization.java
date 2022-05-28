package com.example.taskitmed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "organization")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Основной бизнес идентификатор учреждения, куда пациент направлен для получения назначения
    // Bemorni qabul qilish uchun yuborilgan muassasaning asosiy biznes identifikatori
    private String description;
    private String type;

}