package com.fanou.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fanou.bibliotheque.model.Exemplaire;
import com.fanou.bibliotheque.repository.ExemplaireRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ExemplaireService {
    @Autowired
    private ExemplaireRepository exemplaireRepository;

    public List<Exemplaire> getExemplaires(){
        List<Exemplaire> exemplaires = exemplaireRepository.findAll();
        return exemplaires;
    }

    public Exemplaire getExemplaireById(long id){
        Exemplaire exemplaire = exemplaireRepository.findById(id)
                                                    .orElseThrow(EntityNotFoundException::new);
        return exemplaire;
    }

    public void deleteExemplaire(long id) {
        Exemplaire exemplaire = exemplaireRepository.findById(id)
                                     .orElseThrow(EntityNotFoundException::new);
        exemplaire.getLivre()
                  .getExemplaires()
                  .remove(exemplaire);
        
        exemplaire.setLivre(null);

        exemplaireRepository.delete(exemplaire);       
    }

    public Exemplaire createExemplaire(Exemplaire exemplaire) throws MethodArgumentNotValidException{
       exemplaire.getLivre()
                 .getExemplaires()
                 .add(exemplaire);
                 
       return exemplaireRepository.save(exemplaire);
    }
}
