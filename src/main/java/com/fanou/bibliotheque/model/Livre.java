package com.fanou.bibliotheque.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private String auteur;
    private String edition;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "livre", cascade = CascadeType.ALL)
    private List<Exemplaire> exemplaires;
    
    public Livre(long id, String titre, String auteur, String edition,List<Exemplaire> exemplaires){
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.edition = edition;
        this.exemplaires = exemplaires;
    }

    public Livre(){}

    public long getId(){ return id; }

    public String getTitre() { return titre; }

    public String getAuteur() { return auteur; }

    public String getEdittion() { return edition; }

    public List<Exemplaire> getExemplaires() { return exemplaires; }

    public void setId(long id) { this.id = id; }

    public void setTitre(String titre) { this.titre = titre; }

    public void setAuteur(String auteur) { this.auteur = auteur; }

    public void setEdition(String edition) { this.edition = edition; }

    public void setExemplaires(List<Exemplaire> exemplaires) { this.exemplaires = exemplaires; }
}
