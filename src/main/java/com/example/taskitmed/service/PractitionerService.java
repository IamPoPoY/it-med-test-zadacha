package com.example.taskitmed.service;

import com.example.taskitmed.entity.Practitioner;
import com.example.taskitmed.payload.ApiResult;
import com.example.taskitmed.payload.PractitionerDto;
import com.example.taskitmed.repository.PractitionerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.taskitmed.service.RandomIdentifier.randomIdentifaier;

@Service
@RequiredArgsConstructor
public class PractitionerService {
    private final PractitionerRepository practitionerRepository;

    public ApiResult<Practitioner> add(PractitionerDto practitionerDto) {
        Practitioner practitioner =new Practitioner();
        practitioner.setFullName(practitionerDto.getFullName());
        String random = randomIdentifaier();

        while (practitionerRepository.existsByDescription(random)) {
          random = randomIdentifaier();
        }
        practitioner.setDescription(random);
        practitioner.setType(practitionerDto.getType());
        practitionerRepository.save(practitioner);

        return new ApiResult<>(practitioner, true,"saved !");
    }
}
