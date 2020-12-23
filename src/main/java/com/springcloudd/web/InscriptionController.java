package com.springcloudd.web;

import com.springcloudd.dao.InscriptionRepository;
import com.springcloudd.entities.Inscription;
import com.springcloudd.services.CoursService;
import com.springcloudd.services.EtudiantService;
import com.springcloudd.services.IInscriptionService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class InscriptionController {
    @Autowired
    private IInscriptionService iInscriptionService;
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private CoursService coursService;
    @CrossOrigin("*")
    @GetMapping("/inscriptions")
    public List<Inscription> inscriptions()
    {
        return iInscriptionService.findAll();
    }
    @CrossOrigin("*")
    @PostMapping("/inscriptionEtudiant")
    public List<Inscription> getInscriptionsForStudent(@RequestBody String username)
    {
        return iInscriptionService.getInscriptionForStudent(username);
    }
    @CrossOrigin("*")
    @PostMapping("/saveInscription/{id}")
    public void saveInscription(@PathVariable Long id, @RequestBody Username username)
    {
        Inscription inscription=new Inscription();
        System.out.println(username.getUsername());
        inscription.setDate(new Date());
        inscription.setNameEtudiant(username.getUsername());
        inscription.setIdCours(id);
        iInscriptionService.save(inscription);
        iInscriptionService.findByIdCoursAndAndNameEtudiant(id,username.getUsername());
        System.out.println(inscription.getId());
        coursService.saveInscriptionToCours(id,inscription.getId());
        etudiantService.saveInscription(inscription.getId(),username.getUsername());

    }
    @CrossOrigin("*")
    @GetMapping("/findInscription/{username}")
    public List<Inscription> findInscription(@PathVariable("username") String username)
    {
        System.out.println(username);

        System.out.println(iInscriptionService.findByNameEtudiant(username));
         return iInscriptionService.findByNameEtudiant(username);
    }
    @CrossOrigin("*")
    @GetMapping("/inscription/{id}")
        public String getnameEtudiant(@PathVariable Long id ){
            Inscription inscription = iInscriptionService.findById(id);
            return inscription.getNameEtudiant();
        }


    @CrossOrigin("*")
    @GetMapping("/inscriptions/{id}")
    public Inscription getInscription(@PathVariable Long id ){
        Inscription inscription = iInscriptionService.findById(id);
        return inscription;
    }
    @GetMapping("/inscription/cours/{idCours}")
    public Inscription getInscriptionByCours(@PathVariable("idCours") Long id ){
        Inscription inscription = inscriptionRepository.findByIdCours(id);
        return inscription;
    }

}



@Data
@ToString
class Username
{
    private String username;
}
