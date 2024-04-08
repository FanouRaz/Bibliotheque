package com.fanou.bibliotheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fanou.bibliotheque.model.Exemplaire;
import com.fanou.bibliotheque.service.ExemplaireService;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class ExemplaireController {
    @Autowired
    private ExemplaireService exemplaireService;
    
     @GetMapping("/api/exemplaires")
    public ResponseEntity<List<Exemplaire>> getExemplaires() {
        List<Exemplaire> exemplaires = exemplaireService.getExemplaires();
        return ResponseEntity.ok(exemplaires);
    }

    @GetMapping("/api/exemplaire/{id}")
    public ResponseEntity<Exemplaire> getExemplaireById(@PathVariable("id") long id){
        try{
            Exemplaire exemplaire = exemplaireService.getExemplaireById(id);
            return ResponseEntity.ok(exemplaire);
        }catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/exemplaire/{id}")
    public ResponseEntity<String> deleteExemplaireById(@PathVariable("id") long id){
        try{
            exemplaireService.deleteExemplaire(id);
            return ResponseEntity.ok(String.format("Le Exemplaire ayant pour id %d supprimer avec succès",id));
        }catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/exemplaire")
    public ResponseEntity<Exemplaire> createExemplaire(@RequestBody Exemplaire exemplaire){
        try{
            Exemplaire newExemplaire = exemplaireService.createExemplaire(exemplaire);
            return ResponseEntity.status(HttpStatus.CREATED).body(newExemplaire);
        }catch(MethodArgumentNotValidException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/api/exemplaire/{id}")
    public ResponseEntity<Exemplaire> updateIsDispo(@PathVariable("id") long id){
        try{
            Exemplaire updated = exemplaireService.updateIsDispo(id);
            return ResponseEntity.ok(updated);
        } catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
