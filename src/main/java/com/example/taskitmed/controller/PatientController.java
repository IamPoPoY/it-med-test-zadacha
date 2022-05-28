package com.example.taskitmed.controller;

import com.example.taskitmed.entity.Patient;
import com.example.taskitmed.payload.ApiResult;
import com.example.taskitmed.repository.PatientRepository;
import com.example.taskitmed.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: JADANOV_DILMUROD
 * @date:28.05.2022
 */
@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;
    private final PatientService patientService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody Patient patient){
        ApiResult<Patient> add = patientService.add(patient);
        return ResponseEntity.status(add.isSuccess() ? 201 : 409).body(add);
    }

    @GetMapping
    public HttpEntity<?> list(){
        try {
            return ResponseEntity.ok(patientRepository.findAll());

        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getId(@PathVariable Long id){
       ApiResult<Patient> apiResult = patientService.byId(id);
       return ResponseEntity.status(apiResult.isSuccess() ? 200 : 404).body(apiResult);
    }
}
