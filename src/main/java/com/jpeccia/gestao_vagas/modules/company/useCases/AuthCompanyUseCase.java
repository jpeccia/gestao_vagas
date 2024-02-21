package com.jpeccia.gestao_vagas.modules.company.useCases;

import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jpeccia.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import com.jpeccia.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {
    
    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException{
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
            () -> {
                throw new UsernameNotFoundException("Username/password incorrect");
            });

            var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

            if(!passwordMatches){
                throw new AuthenticationException();
            }

            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            var token = JWT.create().withIssuer("jpeccia")
                .withExpiresAt(Instant.now().plus(java.time.Duration.ofHours(2)))
                .withSubject(company.getId().toString())
                .withClaim("roles", Arrays.asList("COMPANY"))
                .sign(algorithm);

            return token;
    }
}
