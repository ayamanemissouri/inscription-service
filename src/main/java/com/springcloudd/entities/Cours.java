package com.springcloudd.entities;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Cours {
    private Long id;
    private String description;
    private String nom;
    private Difficulte difficulte;
    private int nombreDePlace;
    private String prerequis;
    private List<String> formateurList;
    private List<String> inscriptions;
    private Theme theme;
}
