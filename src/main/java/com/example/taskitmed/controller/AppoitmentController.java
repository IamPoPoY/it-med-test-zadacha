package com.example.taskitmed.controller;

import com.example.taskitmed.entity.Appoitment;
import com.example.taskitmed.payload.ApiResult;
import com.example.taskitmed.payload.AppoitmentDto;
import com.example.taskitmed.repository.AppoitmentRepository;
import com.example.taskitmed.service.AppoitmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appoitment")
@RequiredArgsConstructor
public class AppoitmentController {
    private final AppoitmentRepository appoitmentRepository;
    private final AppoitmentService appoitmentService;

    @PostMapping
    public HttpEntity<?> addAppoitment(@RequestBody AppoitmentDto appoitmentDto) {
        ApiResult<Appoitment> apiResult = appoitmentService.add(appoitmentDto);
        int responseCode;
        if (apiResult.getResponseCode() == 422) {
            responseCode = 422;
        } else if (apiResult.getResponseCode() == 500) {
            responseCode = 500;
        } else {
            responseCode = 201;
        }
        return ResponseEntity.status(responseCode).body(apiResult);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getAppoitment(@PathVariable Integer id) {
        ApiResult<Appoitment> apiResult = appoitmentService.getAppoitment(id);
        int responseCode;
        if (apiResult.getResponseCode() == 404) {
            responseCode = 404;
        } else if (apiResult.getResponseCode() == 500) {
            responseCode = 500;
        } else {
            responseCode = 200;
        }
        return ResponseEntity.status(responseCode).body(apiResult);
    }

    @GetMapping
    public HttpEntity<?> getAllAppoitment() {
        return ResponseEntity.ok(appoitmentRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAppoitment(@PathVariable Integer id) {
        ApiResult apiResult = appoitmentService.deletegetAppoitment(id);
        int responseCode;
        if (apiResult.getResponseCode() == 404) {
            responseCode = 404;
        } else if (apiResult.getResponseCode() == 500) {
            responseCode = 500;
        } else {
            responseCode = 200;
        }
        return ResponseEntity.status(responseCode).body(apiResult);
    }
}
