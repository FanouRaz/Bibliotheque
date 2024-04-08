package com.fanou.bibliotheque.service;

import com.fanou.bibliotheque.model.Exemplaire;
import com.fanou.bibliotheque.model.Livre;
import com.fanou.bibliotheque.repository.LivreRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;
    
    public List <Livre> getLivres(){
        return livreRepository.findAll();
    }

    public Livre getLivreById(long id) {
        Livre livre = livreRepository.findById(id)
                                     .orElseThrow(EntityNotFoundException::new);
        
        return livre;
    }

    public void deleteLivre(long id) {
        Livre livre = livreRepository.findById(id)
                                     .orElseThrow(EntityNotFoundException::new);
       
        livreRepository.delete(livre);       
    }

    public Livre createLivre(Livre livre) throws MethodArgumentNotValidException{
       return livreRepository.save(livre);
    }

    public List<Exemplaire> getExemplairesByBookId(long id){
        Livre livre = livreRepository.findById(id)
                                     .orElseThrow(EntityNotFoundException::new);

        return livre.getExemplaires();
    }

    public Exemplaire createExemplaire(long id_livre, Exemplaire exemplaire){
        Livre livre = livreRepository.findById(id_livre)
                                     .orElseThrow(EntityNotFoundException::new);

        exemplaire.setIsDispo(true);
        exemplaire.setLivre(livre);

        livre.getExemplaires()
             .add(exemplaire);
        
        livreRepository.save(livre);
        return exemplaire;
    }
}
