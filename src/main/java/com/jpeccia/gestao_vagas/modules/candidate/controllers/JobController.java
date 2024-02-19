package com.jpeccia.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jpeccia.gestao_vagas.modules.company.entities.JobEntity;
import com.jpeccia.gestao_vagas.modules.company.useCases.CreateJobUseCase;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/job")

public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    public JobEntity create (@Valid @RequestBody JobEntity jobEntity){
        return this.createJobUseCase.execute(jobEntity);
    }
}
