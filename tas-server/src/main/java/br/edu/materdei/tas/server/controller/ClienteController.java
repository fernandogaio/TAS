package br.edu.materdei.tas.server.controller;

import br.edu.materdei.tas.venda.entity.ClienteEntity;
import br.edu.materdei.tas.venda.service.ClienteService;
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
public class ClienteController {
    
    @Autowired
    private ClienteService service;
    
    @GetMapping("clientes")
    public ResponseEntity<List<ClienteEntity>> findAll() {
        List<ClienteEntity> clientes = service.findAll();
        
        return new ResponseEntity<List<ClienteEntity>>(clientes, HttpStatus.OK);
    }
    
    @PostMapping("clientes")
    public ResponseEntity create(@RequestBody ClienteEntity cliente) {
        try {
            this.service.save(cliente);
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @GetMapping("clientes/{id}")
    public ResponseEntity findByID(@PathVariable("id") Integer id) {

        ClienteEntity cliente = this.service.findById(id);
        
        if (cliente != null)
            return new ResponseEntity(cliente, HttpStatus.OK);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
    }
    
    @PutMapping("clientes/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody ClienteEntity cliente) {
        try {
            ClienteEntity found = this.service.findById(id);
            
            if (found != null) {
                cliente.setId(id);
                
                this.service.save(cliente);
                return new ResponseEntity(cliente, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @DeleteMapping("clientes/{id}")
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
