package com.fanou.bibliotheque.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fanou.bibliotheque.model.Exemplaire;
import com.fanou.bibliotheque.model.Livre;
import com.fanou.bibliotheque.service.LivreService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class LivreController {
    @Autowired
    private LivreService livreService;
    
    @GetMapping("/api/livres")
    public ResponseEntity<List<Livre>> getLivres() {
        List<Livre> livres = livreService.getLivres();
        return ResponseEntity.ok(livres);
    }

    @GetMapping("/api/livre/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable("id") long id){
        try{
            Livre livre = livreService.getLivreById(id);
            return ResponseEntity.ok(livre);
        }catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/livre/{id}")
    public ResponseEntity<String> deleteLivreById(@PathVariable("id") long id){
        try{
            livreService.deleteLivre(id);
            return ResponseEntity.ok(String.format("Le livre ayant pour id %d supprimer avec succès",id));
        }catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/livre")
    public ResponseEntity<Livre> createLivre(@RequestBody Livre livre){
        try{
            Livre newLivre = livreService.createLivre(livre);
            return ResponseEntity.status(HttpStatus.CREATED).body(newLivre);
        }catch(MethodArgumentNotValidException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/api/livre/exemplaires/{id}")
    public ResponseEntity<List<Exemplaire>> getExemplaires(@PathVariable("id") long id) {
        try{
            List<Exemplaire> exemplaires = livreService.getExemplairesByBookId(id);
            return ResponseEntity.ok(exemplaires);
        } catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/livre/exemplaire/{id}")
    public ResponseEntity<Exemplaire> createExemplaire(@PathVariable("id") long id, @RequestBody Exemplaire exemplaire){
        try{
            Exemplaire newExemplaire = livreService.createExemplaire(id,exemplaire);
            return ResponseEntity.ok(newExemplaire);
        } catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    
}
