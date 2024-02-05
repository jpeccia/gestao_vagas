package com.jpeccia.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jpeccia.gestao_vagas.modules.candidate.CandidateEntity;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/candidate")

public class CandidateControler {
    
    @PostMapping("/")
    public void create( @Valid @RequestBody CandidateEntity candidateEntity){{
        System.out.println("Candidato");
        System.out.println(candidateEntity.getEmail());
    }}

}
