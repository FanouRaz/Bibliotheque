package com.fanou.bibliotheque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean isDispo;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "livre_id")
    private Livre livre;

    public Exemplaire(){ }

    public Exemplaire(long id, boolean isDispo, Livre livre){
        this.id = id;
        this.isDispo = isDispo;
        this.livre = livre;
    }

    public long getId() { return id; }

    public boolean getIsDispo() { return isDispo; }

    public Livre getLivre() { return livre; }

    public void setId(long id) { this.id = id; }

    public void setIsDispo(boolean isDispo) { this.isDispo = isDispo; }

    public void setLivre(Livre livre) { this.livre = livre; }

    @Override 
    public boolean equals(Object o){
        if(o instanceof Exemplaire)
            return id == ((Exemplaire) o).getId() && livre == ((Exemplaire) o).livre;

        if(o == null)
            return this == null;
        
        else 
            return false;
    }
}
