package com.fanou.bibliotheque.model;

import java.time.LocalDate;

public class Adherent{
    private int id_adherent;
    private String nom;
    private String prenom;
    private LocalDate date_adhesion;
    static int lastId = 0;

    public Adherent(String nom, String prenom, LocalDate date_adhesion){
        this.id_adherent = lastId++;
        this.nom = nom;
        this.prenom = prenom;
        this.date_adhesion = date_adhesion;
    }

    public int getId(){
        return id_adherent;
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public LocalDate getDateAdhesion(){
        return date_adhesion;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
}