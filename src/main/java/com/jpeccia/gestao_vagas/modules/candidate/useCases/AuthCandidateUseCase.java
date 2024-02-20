package com.jpeccia.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpeccia.gestao_vagas.modules.candidate.CandidateRepository;
import com.jpeccia.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;

@Service
public class AuthCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    public void execute(AuthCandidateRequestDTO authCandidateRequestDTO) {

    }
}
