package com.example.taskitmed.service;

import com.example.taskitmed.entity.Patient;
import com.example.taskitmed.payload.ApiResult;
import com.example.taskitmed.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: JADANOV_DILMUROD
 * @date:28.05.2022
 */

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public ApiResult<Patient> add(Patient patient) {
        if ( patient.getDescription().length() != 8) return new ApiResult<>(false, "")
        Patient patient1 = new Patient();
        patient1.setFullName(patient.getFullName());

    }
}
