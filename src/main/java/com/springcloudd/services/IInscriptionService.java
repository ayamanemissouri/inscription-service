package com.springcloudd.services;

import com.springcloudd.entities.Inscription;

import java.util.List;

public interface IInscriptionService {
    public void save(Inscription inscription);
    public List<Inscription> findAll();
    public List<Inscription> getInscriptionForStudent(String username);
    public Inscription findById(Long id);
    public Inscription findByIdCoursAndAndNameEtudiant(Long id,String username);
    public List<Inscription> findByNameEtudiant(String username);
    public boolean isSame(Inscription i1,Inscription i2);
    public String get();

}
