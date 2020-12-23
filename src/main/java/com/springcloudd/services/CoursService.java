package com.springcloudd.services;

import com.springcloudd.entities.Cours;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("COURS-SERVICE")
public interface CoursService {
    @GetMapping("/courses/{id}")
    public Cours findCoursById(@PathVariable Long id);
    @GetMapping("/courses")
    public Cours findAllcourses();
    @PostMapping("/saveCoursInscr/{id1}:{id2}")
    public Cours saveInscriptionToCours(@PathVariable("id1") Long idCours, @PathVariable("id2")Long idInscription);
}
