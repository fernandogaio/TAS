package br.edu.materdei.tas.server.controller;

import br.edu.materdei.tas.compra.entity.CompraEntity;
import br.edu.materdei.tas.compra.service.CompraService;
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
public class CompraController {
    
    @Autowired
    private CompraService service;
    
    @GetMapping("compras")
    public ResponseEntity<List<CompraEntity>> findAll() {
        List<CompraEntity> compras = service.findAll();
        
        return new ResponseEntity<List<CompraEntity>>(compras, HttpStatus.OK);
    }
    
    @PostMapping("compras")
    public ResponseEntity create(@RequestBody CompraEntity compra) {
        try {
            this.service.save(compra);
            return ResponseEntity.status(HttpStatus.OK).body(compra);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @GetMapping("compras/{id}")
    public ResponseEntity findByID(@PathVariable("id") Integer id) {

        CompraEntity compra = this.service.findById(id);
        
        if (compra != null)
            return new ResponseEntity(compra, HttpStatus.OK);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
    }
    
    @PutMapping("compras/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody CompraEntity compra) {
        try {
            CompraEntity found = this.service.findById(id);
            
            if (found != null) {
                compra.setId(id);
                
                this.service.save(compra);
                return new ResponseEntity(compra, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @DeleteMapping("compras/{id}")
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
