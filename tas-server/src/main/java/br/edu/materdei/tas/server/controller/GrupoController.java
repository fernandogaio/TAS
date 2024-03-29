package br.edu.materdei.tas.server.controller;

import br.edu.materdei.tas.core.entity.GrupoEntity;
import br.edu.materdei.tas.core.service.GrupoService;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrupoController {
    
    @Autowired
    private GrupoService service;
    
    @GetMapping("grupos")
    public ResponseEntity<List<GrupoEntity>> findAll() {
        List<GrupoEntity> grupos = service.findAll();
        
        return new ResponseEntity<List<GrupoEntity>>(grupos, HttpStatus.OK);
    }
    
    @PostMapping("grupos")
    public ResponseEntity create(@RequestBody GrupoEntity grupo) {
        try {
            this.service.save(grupo);
            return ResponseEntity.status(HttpStatus.OK).body(grupo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @GetMapping("grupos/{id}")
    public ResponseEntity findByID(@PathVariable("id") Integer id) {

        GrupoEntity grupo = this.service.findById(id);
        
        if (grupo != null)
            return new ResponseEntity(grupo, HttpStatus.OK);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
    }
    
    @PutMapping("grupos/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody GrupoEntity grupo) {
        try {
            GrupoEntity found = this.service.findById(id);
            
            if (found != null) {
                grupo.setId(id);
                
                this.service.save(grupo);
                return new ResponseEntity(grupo, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @DeleteMapping("grupos/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            this.service.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            
        } catch (EmptyResultDataAccessException e) {
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            
        } catch (ConstraintViolationException e) {
            
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
            
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            
        }
    }
}
