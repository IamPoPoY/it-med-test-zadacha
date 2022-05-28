package com.example.taskitmed.entity;

import com.example.taskitmed.payload.DiseaseTypeEnum;
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
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private DiseaseTypeEnum diseaseType;
    @OneToOne
    private Properties properties;

}
