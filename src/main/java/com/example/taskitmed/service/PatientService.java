package com.example.taskitmed.service;

import com.example.taskitmed.entity.Patient;
import com.example.taskitmed.payload.ApiResult;
import com.example.taskitmed.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: JADANOV_DILMUROD
 * @date:28.05.2022
 */

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public ApiResult<Patient> add(Patient patient) {
        try {
            if (patient.getDescription().length() != 8) return new ApiResult<>(null, false, "Length Error !");



            Patient patient1 = new Patient();
            patient1.setFullName(patient.getFullName());
            patient1.setDescription(patient.getDescription());
            patient1.setType(patient.getType());

            Patient save = patientRepository.save(patient1);
            return new ApiResult<>(save, true, "Saved !");

        }catch (Exception e){
         throw new RuntimeException(e);
        }

    }

    public ApiResult<Patient> byId(Long id) {

        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.map(patient -> new ApiResult<>(patient, true, "Ok")).orElseGet(() -> new ApiResult<>(null, false, "Not Found Patient !"));

    }
}
