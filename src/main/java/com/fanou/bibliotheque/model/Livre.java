package com.fanou.bibliotheque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private String auteur;
    private String edition;

    public Livre(long id, String titre, String auteur, String edition){
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.edition = edition;
    }

    public Livre(){}

    public long getId(){ return id; }

    public String getTitre() { return titre; }

    public String getAuteur() { return auteur; }

    public String getEdittion() { return edition; }

    public void setId(long id) { this.id = id; }

    public void setTitre(String titre) { this.titre = titre; }

    public void setAuteur(String auteur) { this.auteur = auteur; }

    public void setEdition(String edition) { this.edition = edition; }
}
