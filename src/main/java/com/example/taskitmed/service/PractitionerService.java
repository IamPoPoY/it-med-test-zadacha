package com.example.taskitmed.service;

import com.example.taskitmed.entity.Practitioner;
import com.example.taskitmed.payload.ApiResult;
import com.example.taskitmed.payload.PractitionerDto;
import com.example.taskitmed.repository.PractitionerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PractitionerService {
    private final PractitionerRepository practitionerRepository;

    public String randomIdentifaier(){
        long timeSeed = System.nanoTime(); // to get the current date time value

        double randSeed = Math.random() * 1000; // random number generation

        long midSeed = (long) (timeSeed * randSeed); // mixing up the time and

        String s = midSeed + "";
        String subStr = s.substring(0, 9);

      return subStr;
    }
    public ApiResult<Practitioner> add(PractitionerDto practitionerDto) {
        Practitioner practitioner =new Practitioner();
        practitioner.setFullName(practitionerDto.getFullName());
        String random = randomIdentifaier();

        while (!practitionerRepository.existsByDescription(random)) {
            randomIdentifaier();
        }
        practitioner.setDescription(random);
        practitioner.setType(practitionerDto.getType());
        practitionerRepository.save(practitioner);

        return new ApiResult<>(practitioner, true,"saved !");
    }
}
