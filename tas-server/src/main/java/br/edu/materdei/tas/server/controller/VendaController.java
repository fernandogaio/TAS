package br.edu.materdei.tas.server.controller;

import br.edu.materdei.tas.venda.entity.VendaEntity;
import br.edu.materdei.tas.venda.service.VendaService;
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
public class VendaController {
    
    @Autowired
    private VendaService service;
    
    @GetMapping("vendas")
    public ResponseEntity<List<VendaEntity>> findAll() {
        List<VendaEntity> vendas = service.findAll();
        
        return new ResponseEntity<List<VendaEntity>>(vendas, HttpStatus.OK);
    }
    
    @PostMapping("vendas")
    public ResponseEntity create(@RequestBody VendaEntity venda) {
        try {
            this.service.save(venda);
            return ResponseEntity.status(HttpStatus.OK).body(venda);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @GetMapping("vendas/{id}")
    public ResponseEntity findByID(@PathVariable("id") Integer id) {

        VendaEntity venda = this.service.findById(id);
        
        if (venda != null)
            return new ResponseEntity(venda, HttpStatus.OK);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
    }
    
    @PutMapping("vendas/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody VendaEntity venda) {
        try {
            VendaEntity found = this.service.findById(id);
            
            if (found != null) {
                venda.setId(id);
                
                this.service.save(venda);
                return new ResponseEntity(venda, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @DeleteMapping("vendas/{id}")
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
