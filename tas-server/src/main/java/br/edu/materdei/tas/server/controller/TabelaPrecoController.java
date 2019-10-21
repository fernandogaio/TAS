package br.edu.materdei.tas.server.controller;

import br.edu.materdei.tas.venda.entity.TabelaPrecoEntity;
import br.edu.materdei.tas.venda.service.TabelaPrecoService;
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
public class TabelaPrecoController {
    
    @Autowired
    private TabelaPrecoService service;
    
    @GetMapping("tabelaprecos")
    public ResponseEntity<List<TabelaPrecoEntity>> findAll() {
        List<TabelaPrecoEntity> tabelaprecos = service.findAll();
        
        return new ResponseEntity<List<TabelaPrecoEntity>>(tabelaprecos, HttpStatus.OK);
    }
    
    @PostMapping("tabelaprecos")
    public ResponseEntity create(@RequestBody TabelaPrecoEntity tabelapreco) {
        try {
            this.service.save(tabelapreco);
            return ResponseEntity.status(HttpStatus.OK).body(tabelapreco);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @GetMapping("tabelaprecos/{id}")
    public ResponseEntity findByID(@PathVariable("id") Integer id) {

        TabelaPrecoEntity tabelapreco = this.service.findById(id);
        
        if (tabelapreco != null)
            return new ResponseEntity(tabelapreco, HttpStatus.OK);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
    }
    
    @PutMapping("tabelaprecos/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody TabelaPrecoEntity tabelapreco) {
        try {
            TabelaPrecoEntity found = this.service.findById(id);
            
            if (found != null) {
                tabelapreco.setId(id);
                
                this.service.save(tabelapreco);
                return new ResponseEntity(tabelapreco, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @DeleteMapping("tabelaprecos/{id}")
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
