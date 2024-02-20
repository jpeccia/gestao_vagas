package com.jpeccia.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jpeccia.gestao_vagas.modules.candidate.CandidateEntity;
import com.jpeccia.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import com.jpeccia.gestao_vagas.modules.candidate.useCases.ProfileCandidateUseCase;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/candidate")

public class CandidateController {
    
    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @Autowired

    private ProfileCandidateUseCase profileCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity){
        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get() {
        try {
            var profile = this.profileCandidateUseCase.execute(null);

            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    }


