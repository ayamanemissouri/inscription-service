package com.springcloudd.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("USER-SERVICE")
public interface EtudiantService {
    @PostMapping("/saveInscription/{etudiant}:{id}")
    public void saveInscription(@PathVariable("id") Long id, @PathVariable("etudiant") String username);
}
