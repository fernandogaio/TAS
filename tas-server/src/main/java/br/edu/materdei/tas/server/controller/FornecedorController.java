package br.edu.materdei.tas.server.controller;

import br.edu.materdei.tas.compra.entity.FornecedorEntity;
import br.edu.materdei.tas.compra.service.FornecedorService;
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
public class FornecedorController {
    
    @Autowired
    private FornecedorService service;
    
    @GetMapping("fornecedores")
    public ResponseEntity<List<FornecedorEntity>> findAll() {
        List<FornecedorEntity> fornecedores = service.findAll();
        
        return new ResponseEntity<List<FornecedorEntity>>(fornecedores, HttpStatus.OK);
    }
    
    @PostMapping("fornecedores")
    public ResponseEntity create(@RequestBody FornecedorEntity fornecedor) {
        try {
            this.service.save(fornecedor);
            return ResponseEntity.status(HttpStatus.OK).body(fornecedor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @GetMapping("fornecedores/{id}")
    public ResponseEntity findByID(@PathVariable("id") Integer id) {

        FornecedorEntity fornecedor = this.service.findById(id);
        
        if (fornecedor != null)
            return new ResponseEntity(fornecedor, HttpStatus.OK);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
    }
    
    @PutMapping("fornecedores/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody FornecedorEntity fornecedor) {
        try {
            FornecedorEntity found = this.service.findById(id);
            
            if (found != null) {
                fornecedor.setId(id);
                
                this.service.save(fornecedor);
                return new ResponseEntity(fornecedor, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @DeleteMapping("fornecedores/{id}")
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
