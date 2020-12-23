package com.springcloudd;

import com.springcloudd.dao.InscriptionRepository;
import com.springcloudd.entities.Inscription;
import com.springcloudd.services.IInscriptionService;
import com.springcloudd.services.InscriptionServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

import static reactor.core.publisher.Mono.when;
@SpringBootTest
public class AssertjTest {

    private InscriptionServiceImpl inscriptionService=new InscriptionServiceImpl();

    @Test
    void testInscriptionSame()
    {
        Inscription firstInscription=new Inscription(null,new Date(),true,15L,"Aymane");
        Inscription secondInscription2=new Inscription(null,new Date(),true,17L,"Aymane");
        boolean result=this.inscriptionService.isSame(firstInscription,secondInscription2);
        Assertions.assertThat(result).isEqualTo(false);
    }
    @Test
    void testInsciptionsSameCourse()
    {
        Inscription firstInscription=new Inscription();
        Inscription secondInscription=new Inscription();
        firstInscription.setIdCours(5L);
        secondInscription.setIdCours(5L);
        boolean result=this.inscriptionService.isSameCourseForBoth(firstInscription,secondInscription);
        Assertions.assertThat(result).isEqualTo(true);

    }
}
