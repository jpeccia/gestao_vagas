package com.jpeccia.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID id;
    
    @NotBlank()
    @Pattern(regexp = "^\\S+", message = "O campo [username] não deve conter espaço.")
    @Schema(example = "empresa", requiredMode = RequiredMode.REQUIRED, description = "Usuário da empresa")
    private String username;

    @Email(message = "O campo (email) deve conter um email válido.")
    @Schema(example = "teste@empresa.com", requiredMode = RequiredMode.REQUIRED, description = "E-mail da empresa")
    private String email;

    @Length(min = 10, max = 100, message = "A senha deve conter entre 10 e 100 caracteres.")
    @Schema(example = "company@1234", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Senha da empresa")
    private String password;

    @Schema(example = "www.empresateste.com", requiredMode = RequiredMode.REQUIRED, description = "Site da empresa")
    private String website;

    @Schema(example = "Empresa de desenvolvimento Java", requiredMode = RequiredMode.REQUIRED, description = "Nome da empresa")
    private String name;

    @Schema(example = "Empresa que atua na area de Desenvolvimento Java", requiredMode = RequiredMode.REQUIRED, description = "Breve descrição da empresa")
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
