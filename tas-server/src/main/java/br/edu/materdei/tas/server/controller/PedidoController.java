package br.edu.materdei.tas.server.controller;

import br.edu.materdei.tas.venda.entity.PedidoEntity;
import br.edu.materdei.tas.venda.service.PedidoService;
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
public class PedidoController {
    
    @Autowired
    private PedidoService service;
    
    @GetMapping("pedidos")
    public ResponseEntity<List<PedidoEntity>> findAll() {
        List<PedidoEntity> pedidos = service.findAll();
        
        return new ResponseEntity<List<PedidoEntity>>(pedidos, HttpStatus.OK);
    }
    
    @PostMapping("pedidos")
    public ResponseEntity create(@RequestBody PedidoEntity pedido) {
        try {
            this.service.save(pedido);
            return ResponseEntity.status(HttpStatus.OK).body(pedido);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @GetMapping("pedidos/{id}")
    public ResponseEntity findByID(@PathVariable("id") Integer id) {

        PedidoEntity pedido = this.service.findById(id);
        
        if (pedido != null)
            return new ResponseEntity(pedido, HttpStatus.OK);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
    }
    
    @PutMapping("pedidos/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody PedidoEntity pedido) {
        try {
            PedidoEntity found = this.service.findById(id);
            
            if (found != null) {
                pedido.setId(id);
                
                this.service.save(pedido);
                return new ResponseEntity(pedido, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @DeleteMapping("pedidos/{id}")
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
