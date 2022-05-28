package com.example.taskitmed.controller;

import com.example.taskitmed.entity.Patient;
import com.example.taskitmed.repository.PatientRepository;
import com.example.taskitmed.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: JADANOV_DILMUROD
 * @date:28.05.2022
 */
@RestController
@RequestMapping("/api/ patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;
    private final PatientService patientService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody Patient patient){
        patientService.add(patient);
    }
}
