package com.jpeccia.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jpeccia.gestao_vagas.exceptions.UserFoundException;
import com.jpeccia.gestao_vagas.modules.candidate.CandidateEntity;
import com.jpeccia.gestao_vagas.modules.candidate.CandidateRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/candidate")

public class CandidateControler {
    
    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public @Valid CandidateEntity create( @Valid @RequestBody CandidateEntity candidateEntity){{
        
        this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });
        return this.candidateRepository.save(candidateEntity);
    }}

}
