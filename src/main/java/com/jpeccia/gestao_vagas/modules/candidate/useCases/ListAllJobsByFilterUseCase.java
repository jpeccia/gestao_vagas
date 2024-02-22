package com.jpeccia.gestao_vagas.modules.candidate.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpeccia.gestao_vagas.modules.company.entities.JobEntity;
import com.jpeccia.gestao_vagas.modules.company.repositories.JobRepository;

import io.swagger.v3.oas.annotations.servers.Server;

@Server
public class ListAllJobsByFilterUseCase {
    
    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter) {
        return this.jobRepository.findByDescriptionContaing(filter);
    }
}
