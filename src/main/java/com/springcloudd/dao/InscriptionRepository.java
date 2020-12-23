package com.springcloudd.dao;


import com.springcloudd.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
    public List<Inscription> findByNameEtudiant(String username);
    public Inscription findByIdCoursAndAndNameEtudiant(Long id,String username);
    Inscription findByIdCours(Long idcours);

}
