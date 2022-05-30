package com.example.taskitmed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Appoitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Identifier identifier;

    // 9 xonali bemor raqami
    private String patient;

    // 9 xonali shifokor raqami
    private String praction;

    // 9 xonali tashkiloot raqami
    private String oranization;

}
