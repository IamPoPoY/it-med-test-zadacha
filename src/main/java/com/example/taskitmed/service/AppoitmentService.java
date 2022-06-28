package com.example.taskitmed.service;

import com.example.taskitmed.component.MessageService;
import com.example.taskitmed.entity.Appoitment;
import com.example.taskitmed.entity.Identifier;
import com.example.taskitmed.payload.ApiResult;
import com.example.taskitmed.payload.AppoitmentDto;
import com.example.taskitmed.repository.AppoitmentRepository;
import com.example.taskitmed.repository.IdentifierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class AppoitmentService {
    private final AppoitmentRepository appoitmentRepository;
    private final IdentifierRepository identifierRepository;

    private static boolean IsMatch(String s, String pattern) {
        try {
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(s);
            return matcher.matches();
        } catch (RuntimeException e) {
            return false;
        }
    }


    public ApiResult<Appoitment> add(AppoitmentDto appoitmentDto) {

        try {
            Identifier identifier = new Identifier();
            Appoitment appoitment = new Appoitment();

            if (appoitmentRepository.existsByIdentifier_SystemUrl(appoitmentDto.getSystemUrl()))
                return new ApiResult<>(null, 422, MessageService.alreadyExists(" system "));

            String patient = RandomIdentifier.randomIdentifaier();
            while (appoitmentRepository.existsByPatient(patient)) {
                patient = RandomIdentifier.randomIdentifaier();
            }
            String praction = RandomIdentifier.randomIdentifaier();
            while (appoitmentRepository.existsByPraction(praction)) {
                praction = RandomIdentifier.randomIdentifaier();
            }
            String oranization = RandomIdentifier.randomIdentifaier();
            while (appoitmentRepository.existsByOranization(oranization)) {
                oranization = RandomIdentifier.randomIdentifaier();
            }
            String value = RandomIdentifier.randomIdentifaier();
            if (appoitmentRepository.existsByIdentifier_Values(value)) {
                return new ApiResult<>(null, 422, MessageService.alreadyExists(" value "));

            }


            identifier.setValues(value);
            String systemUrl = appoitmentDto.getSystemUrl();
            String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
            if (!IsMatch(systemUrl,regex)) {
                    return new ApiResult(null, 500, "such URL is not valid");
            }
            identifier.setSystemUrl(appoitmentDto.getSystemUrl());


            identifierRepository.save(identifier);

            appoitment.setIdentifier(identifier);
            appoitment.setPatient(patient);
            appoitment.setPraction(praction);
            appoitment.setOranization(oranization);
            appoitmentRepository.save(appoitment);

            return new ApiResult<>(appoitment, 201, MessageService.successSave(" Appoitment "));

        } catch (Exception e) {
            return new ApiResult(e, 500, MessageService.serverError());
        }
    }

    public ApiResult<Appoitment> getAppoitment(Integer id) {
        try {
            Optional<Appoitment> optionalAppoitment = appoitmentRepository.findById(id);
            if (optionalAppoitment.isPresent()) {
                Appoitment appoitment = optionalAppoitment.get();
                return new ApiResult<>(appoitment, 200, "successfully found");
            }
            return new ApiResult<>(null, 404, MessageService.notFound(" appoitment "));

        } catch (Exception e) {
            return new ApiResult<>(null, 500, MessageService.serverError());
        }
    }

    public ApiResult deletegetAppoitment(Integer id) {
        try {
            if (appoitmentRepository.existsById(id)) {
                appoitmentRepository.deleteById(id);
                return new ApiResult(null, 200, MessageService.successDelete(" appoitment "));
            } else return new ApiResult(null, 404, MessageService.notFound(" appoitment "));


        } catch (Exception e) {
            return new ApiResult<>(null, 500, MessageService.serverError());
        }

    }

}
