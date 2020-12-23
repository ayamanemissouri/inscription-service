package com.springcloudd.services;

import com.springcloudd.dao.InscriptionRepository;
import com.springcloudd.entities.Inscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InscriptionServiceImpl implements IInscriptionService{
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Override
    public void save(Inscription inscription) {
        inscriptionRepository.save(inscription);

    }


    @Override
    public List<Inscription> findAll() {
        return inscriptionRepository.findAll();
    }

    @Override
    public List<Inscription> getInscriptionForStudent(String username) {
        return inscriptionRepository.findByNameEtudiant(username);
    }

    @Override
    public Inscription findById(Long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public Inscription findByIdCoursAndAndNameEtudiant(Long id, String username) {
        return inscriptionRepository.findByIdCoursAndAndNameEtudiant(id,username);
    }
    public List<Inscription> findByNameEtudiant(String username)
    {
        return inscriptionRepository.findByNameEtudiant(username);
    }
    @Override
    public boolean isSame(Inscription i1,Inscription i2)
    {
        return i1.equals(i2);
    }

    @Override
    public String get() {
        return "Hello From Inscription Service";
    }

    public boolean isSameCourseForBoth(Inscription i1, Inscription i2) {
        return i1.getIdCours()==i2.getIdCours();
    }
}
