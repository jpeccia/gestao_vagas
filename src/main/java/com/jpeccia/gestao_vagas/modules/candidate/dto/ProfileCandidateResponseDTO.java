package com.jpeccia.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {
    
    @Schema(example = "Desenvolvedor Java Back-End")
    private String description;

    @Schema(example = "jpeccia")
    private String username;

    @Schema(example = "joaootaviopeccia0@gmail.com")
    private String email;
    private UUID id;

    @Schema(example = "João Otávio Peccia")
    private String name;
}
