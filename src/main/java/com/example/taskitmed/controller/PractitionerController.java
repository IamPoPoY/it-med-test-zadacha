package com.example.taskitmed.controller;

import com.example.taskitmed.entity.Practitioner;
import com.example.taskitmed.payload.ApiResult;
import com.example.taskitmed.payload.PractitionerDto;
import com.example.taskitmed.service.PractitionerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Practitioner")
@RequiredArgsConstructor
public class PractitionerController {
    private final PractitionerService practitionerService;
    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody PractitionerDto practitionerDto){
        ApiResult<Practitioner> add = practitionerService.add(practitionerDto);
        return ResponseEntity.ok(add);

    }

}
