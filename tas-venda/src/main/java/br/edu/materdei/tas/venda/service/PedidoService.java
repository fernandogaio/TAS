package br.edu.materdei.tas.venda.service;

import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.venda.entity.PedidoEntity;
import br.edu.materdei.tas.venda.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService implements IBaseService<PedidoEntity> {
    
    @Autowired
    private PedidoRepository repository;

    @Override
    public List<PedidoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public PedidoEntity findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public PedidoEntity save(PedidoEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
