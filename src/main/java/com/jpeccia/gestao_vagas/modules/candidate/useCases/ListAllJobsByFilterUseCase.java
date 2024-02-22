package com.jpeccia.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpeccia.gestao_vagas.modules.company.repositories.JobRepository;

import io.swagger.v3.oas.annotations.servers.Server;

@Server
public class ListAllJobsByFilterUseCase {
    
    @Autowired
    private JobRepository jobRepository;

    public void execute(String filter) {


    }
}
