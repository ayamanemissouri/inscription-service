package com.springcloudd;

import com.springcloudd.dao.InscriptionRepository;
import com.springcloudd.entities.Inscription;
import com.springcloudd.services.IInscriptionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockitoTest {
    @Mock
    public IInscriptionService iInscriptionService;
    @Mock
    public InscriptionRepository inscriptionRepository;
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void testRepositoryInstance()
    {
        when(iInscriptionService.get()).thenReturn("Hello From Mockito");
    }
    @DisplayName("Test Mock helloService + Inscription Service")
    @Test
    void testGet() {
        Assertions.assertThat(this.iInscriptionService.get()).isEqualTo("Hello From Mockito");
    }
    @Test
    void testGetInscription() throws MalformedURLException {

        ResponseEntity<Inscription> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/inscription/cours/"+5).toString(), Inscription.class);
        System.out.println(response.getBody());
        Assertions.assertThat(response.getBody().getIdCours()).isEqualTo(5);

    }
}
