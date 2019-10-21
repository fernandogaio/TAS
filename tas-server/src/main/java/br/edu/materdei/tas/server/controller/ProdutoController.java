package br.edu.materdei.tas.server.controller;

import br.edu.materdei.tas.core.entity.ProdutoEntity;
import br.edu.materdei.tas.core.service.ProdutoService;
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
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;
    
    @GetMapping("produtos")
    public ResponseEntity<List<ProdutoEntity>> findAll() {
        List<ProdutoEntity> produtos = service.findAll();
        
        return new ResponseEntity<List<ProdutoEntity>>(produtos, HttpStatus.OK);
    }
    
    @PostMapping("produtos")
    public ResponseEntity create(@RequestBody ProdutoEntity produto) {
        try {
            this.service.save(produto);
            return ResponseEntity.status(HttpStatus.OK).body(produto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @GetMapping("produtos/{id}")
    public ResponseEntity findByID(@PathVariable("id") Integer id) {

        ProdutoEntity produto = this.service.findById(id);
        
        if (produto != null)
            return new ResponseEntity(produto, HttpStatus.OK);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
    }
    
    @PutMapping("produtos/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody ProdutoEntity produto) {
        try {
            ProdutoEntity found = this.service.findById(id);
            
            if (found != null) {
                produto.setId(id);
                
                this.service.save(produto);
                return new ResponseEntity(produto, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @DeleteMapping("produtos/{id}")
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
