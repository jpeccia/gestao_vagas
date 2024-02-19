package com.jpeccia.gestao_vagas.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpeccia.gestao_vagas.modules.company.entities.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity,UUID> {
    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);
}
